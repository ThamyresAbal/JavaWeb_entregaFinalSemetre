package testesDao;

import java.util.List;

import dao.ContatoDao;
import negocio.Contato;

public class TestaContato {

	public static void main(String[] args) {
		
		 // instancia da classe Contato
		Contato contato = new Contato();
		contato.setEmail("marize@marize.com");
		contato.setTelefone("(21) xxxxx-xxxx");
		contato.setCelular("(21) xxxxx-xxxx");
		
		ContatoDao.incluir(contato);
		
		List<Contato> Lista = ContatoDao.obterLista();
		for (Contato c : Lista) {
			c.divulgar();		
		}

		

	}

}
