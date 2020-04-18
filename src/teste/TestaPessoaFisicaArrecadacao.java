package teste;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import dao.ArrecadacaoDao;
import dao.PessoaFisicaDao;
import negocio.Arrecadacao;
import negocio.Contato;
import negocio.Endereco;
import negocio.PessoaFisica;

public class TestaPessoaFisicaArrecadacao {

	public static void main(String[] args) {
		Calendar DataNascimento = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");        
		try {
		     Date data = (Date)df.parse("24/08/1978");            
		     DataNascimento.setTime(data);
			} catch (ParseException e) {
				e.printStackTrace();
			}	       
		
		Calendar dataAtividade = Calendar.getInstance();
		DateFormat df2 = new SimpleDateFormat("dd/MM/yyyy");        
		try {
		     Date data = (Date)df2.parse("24/08/1978");            
		     dataAtividade.setTime(data);
			} catch (ParseException e) {
				e.printStackTrace();
			}	       
		Calendar hora = Calendar.getInstance();        
        DateFormat dateFormat = new SimpleDateFormat("hh:mm");        
        try {
            Date dt = (Date)dateFormat.parse("23:50");
	        hora.setTime(dt);
		} catch (ParseException e) {
			e.printStackTrace();
		}       
      
        		
	        // instancia da classe Contato
			Contato contato = new Contato();
			contato.setEmail("marize@marize.com");
			contato.setTelefone("(21) xxxxx-xxxx");
			contato.setCelular("(21) xxxxx-xxxx");
	
			// instancia da classe Pessoa Física
			PessoaFisica pf = new PessoaFisica();
			// atributos da classe mãe(usuário)
			pf.setUsuario("MariZé");
			pf.setSenha("sifugonçalves");
			// atributos da classe pessoa
			pf.setNome("Maria José da Silva Santos");
			pf.setNomeSocial("Maria da Silva");
			pf.setDataNascimento(DataNascimento);
			pf.setCpf("xxx.xxx.xxx-xx");
			pf.setGenero("Feminino");
			pf.setContato(contato);
			pf.imprimirTipo();
	
			// instancia de endereço
			Endereco end = new Endereco();
			end.setCep("xxxxx-xxx");
			end.setRua("rua 5 de Mario");
			end.setBairro("Engenho do Porto");
			end.setCidade("DC");
			end.setUf("RJ");
			end.setComplemento("número XXX");
			
					
			Arrecadacao arrecadacao = new Arrecadacao();
			arrecadacao.setNomeAtividade("Long Jin Quan ");
			arrecadacao.setDataAtividade(dataAtividade);
			arrecadacao.setHora(hora);
			arrecadacao.setCategoria("Arrecadação de Alimentos");
			arrecadacao.setDescricao("Campanha natalina- Arrecadaremos alimentos para a montagem de cestas básicas");
			//atributos de arrecadacao
			arrecadacao.setMetaArrecadacao(50);
			arrecadacao.setPublicoAlvo("familias");
			arrecadacao.setQtdAlimentos(50);
			arrecadacao.setQtdBrinquedosRoupas(12);
			arrecadacao.setEndereco(end);
			arrecadacao.setPessoaFisica(pf);
			arrecadacao.imprimirTipo();
			
			ArrecadacaoDao.obterLista(arrecadacao);
		
	}
}


