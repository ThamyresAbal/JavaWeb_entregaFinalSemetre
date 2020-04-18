package testesDao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import dao.ArrecadacaoDao;
import dao.DoacaoMonetariaDao;
import negocio.Arrecadacao;
import negocio.DoacaoMonetaria;
import negocio.Endereco;

public class TestaDoacaoMonetaria {

	public static void main(String[] args) {
//Criação da data e hora
		       
		
		
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
            Date dt = (Date)dateFormat.parse("12:50");
	        hora.setTime(dt);
		} catch (ParseException e) {
			e.printStackTrace();
		}        
       
						        
		// instancia da classe Doação
		DoacaoMonetaria doacao = new DoacaoMonetaria();
		// atributos da mãe(atividade)
		doacao.setNomeAtividade("Camapanha natalina");
		doacao.setDataAtividade(dataAtividade);
		doacao.setHora(hora);
		doacao.setCategoria("Ajuda");
		doacao.setDescricao("Campanha natalina- Arrecadaremos fundos para a montagem de cestas básicas");
		// atributos de doação
		doacao.setValorDoacao(120);
		doacao.setMetaArrecadacao(5000);
		doacao.setValorArrecadado(1000);
	//	doacao.setEndereco(end);
		
		//DoacaoMonetariaDao.incluir(doacao);
		
		List<DoacaoMonetaria> Lista = DoacaoMonetariaDao.obterLista();
		for (DoacaoMonetaria doa : Lista) {
			doa.divulgar();		
		}
	}

}
