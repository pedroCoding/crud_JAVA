package br.com.check.dao;

import java.sql.Connection;
import java.sql.Date;

import com.mysql.cj.jdbc.JdbcPreparedStatement;

import br.com.check.factory.ConnectionFactory;
import br.com.check.model.Contato;

public class ContatoDAO {

	public void save(Contato contato) {
		
		String sql = "INSERT INTO contatos(nome, idade, datacadastro) VALUES (?,?,?)";
		
		Connection conn = null;
		JdbcPreparedStatement pstm = null;
		
		try {
			//Criar uma conexão com o banco de dados
			conn = ConnectionFactory.createConnectionToMySQL();
			
			
			pstm = (JdbcPreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));
			
			//Executar uma query
			pstm.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//Fechar as conexões
			try {
				if(pstm!=null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
