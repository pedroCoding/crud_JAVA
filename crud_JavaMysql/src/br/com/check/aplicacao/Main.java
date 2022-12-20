package br.com.check.aplicacao;

import java.util.Date;

import br.com.check.dao.ContatoDAO;
import br.com.check.model.Contato;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ContatoDAO contatoDao = new ContatoDAO();
		
		Contato contato = new Contato();
		contato.setNome("Pedro");
		contato.setId(3);
		contato.setDataCadastro(new Date());
		contato.setIdade(19);
		
		Contato contato1 = new Contato();
		contato.setNome("Teste");
		contato.setId(5);
		contato.setDataCadastro(new Date());
		contato.setIdade(20);
		
		contatoDao.save(contato);

	}

}
