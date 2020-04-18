package teste;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import negocio.Arrecadacao;
import negocio.Atividade;
import negocio.Contato;
import negocio.DoacaoMonetaria;
import negocio.Endereco;
import negocio.Oficina;
import negocio.PessoaFisica;

public class TestaPessoaFisicaAtividade {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		List<Atividade> atividades = new ArrayList<Atividade>();
		
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
		arrecadacao.setMetaArrecadacao(50);
		arrecadacao.setPublicoAlvo("familias");
		arrecadacao.setQtdAlimentos(50);
		arrecadacao.setQtdBrinquedosRoupas(12);
		arrecadacao.setEndereco(end);
		
		Contato contato = new Contato();
		contato.setEmail("marize@marize.com");
		contato.setTelefone("(21) xxxxx-xxxx");
		contato.setCelular("(21) xxxxx-xxxx");
     	
		Oficina oficina = new Oficina();
		oficina.setNomeAtividade("Mais Atividades teatrais");
		oficina.setDataAtividade(dataAtividade);
		oficina.setHora(hora);
		oficina.setCategoria("Artes");
		oficina.setDescricao("Curso de teatro com Abílio Ramos");
		oficina.setQtdParticipantes(20);
		oficina.setEndereco(end);

		DoacaoMonetaria doacaoMonetaria = new DoacaoMonetaria();
		doacaoMonetaria.setNomeAtividade("Camapanha natalina");
		doacaoMonetaria.setDataAtividade(dataAtividade);
		doacaoMonetaria.setHora(hora);
		doacaoMonetaria.setCategoria("Ajuda");
		doacaoMonetaria.setDescricao("Campanha natalina- Arrecadaremos fundos para a montagem de cestas básicas");
		doacaoMonetaria.setValorDoacao(120);
		doacaoMonetaria.setMetaArrecadacao(5000);
		doacaoMonetaria.setValorArrecadado(1000);
		doacaoMonetaria.setEndereco(end);
		
		atividades.add(doacaoMonetaria);
		atividades.add(oficina);
		atividades.add(arrecadacao);
		
		PessoaFisica pf = new PessoaFisica();
		pf.setUsuario("MariZé");
		pf.setSenha("sifugonçalves");
		pf.setNome("Maria José da Silva Santos");
		pf.setNomeSocial("Maria da Silva");
		pf.setDataNascimento(DataNascimento);
		pf.setCpf("xxx.xxx.xxx-xx");
		pf.setGenero("Feminino");
		pf.setContato(contato);
		pf.setAtividade(atividades);
		pf.imprimirTipo();
		
	
		
		PessoaFisica.incluir(pf);
	}

}