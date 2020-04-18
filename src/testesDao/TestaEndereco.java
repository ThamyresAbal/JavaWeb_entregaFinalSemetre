package testesDao;

import java.util.List;

import dao.EnderecoDao;
import negocio.Endereco;

public class TestaEndereco {

	public static void main(String[] args) {
// instancia de endereço
		Endereco end = new Endereco();
		end.setCep("xxxxx-xxx");
		end.setRua("Rua da Esperança");
		end.setBairro("Alegria");
		end.setCidade("DC");
		end.setUf("RJ");
		end.setComplemento("número XXX");
		
		EnderecoDao.incluir(end);
		
		List<Endereco> Lista = EnderecoDao.obterLista();
		for (Endereco e: Lista) {
			e.divulgar();		
		}
	}

}
