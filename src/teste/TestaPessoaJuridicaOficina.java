package teste;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import negocio.Contato;
import negocio.Endereco;
import negocio.Oficina;
import negocio.PessoaJuridica;

public class TestaPessoaJuridicaOficina {

	public static void main(String[] args) {
		Calendar dataAtividade = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");        
		try {
		     Date data = (Date)df.parse("24/08/1978");            
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

		// instancia da classe Pessoa Jurídica
		PessoaJuridica pj = new PessoaJuridica();
		// atributos da classe mãe(usuário)
		pj.setUsuario("Empresax");
		pj.setSenha("123455w");
		// atributos da classe pessoa
		pj.setNomeEmpresa("Infnet");
		pj.setCnpj("231424315243");
		pj.setRazaoSocial("Instituto de tecnologia Infnet");
		pj.setContato(contato);
		pj.imprimirTipo();
		
		// instancia de endereço
		Endereco end = new Endereco();
		end.setCep("xxxxx-xxx");
		end.setRua("Rua São José");
		end.setBairro("Centro");
		end.setCidade("Rio de Janeiro");
		end.setUf("RJ");
		end.setComplemento("número 90");
		
		// instancia de oficina
		Oficina oficina = new Oficina();
		// atributos da mãe (atividade)
		oficina.setNomeAtividade("Seja programador!!!");
		oficina.setDataAtividade(dataAtividade);
		oficina.setHora(hora);
		oficina.setCategoria("curso");
		oficina.setDescricao("Curso de python");
		// atributos de oficina
		oficina.setQtdParticipantes(20);
		oficina.setEndereco(end);
		oficina.imprimirTipo();
	    
	}

}
