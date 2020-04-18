package testesDao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import dao.ArrecadacaoDao;
import dao.ContatoDao;
import negocio.Arrecadacao;
import negocio.Contato;
import negocio.Endereco;

public class TestaArrecadacao {

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
		
		
		Arrecadacao arrecadacao = new Arrecadacao();
		arrecadacao.setNomeAtividade("Long Jin Quan ");
		arrecadacao.setDataAtividade(dataAtividade);
		arrecadacao.setHora(hora);
		arrecadacao.setCategoria("Arrecadação de Alimentos");
		arrecadacao.setDescricao("Campanha natalina- Arrecadaremos alimentos para a montagem de cestas básicas");
		//atributos de arrecadacao
		arrecadacao.setQtdParticipantes(30);
		arrecadacao.setMetaArrecadacao(50);
		arrecadacao.setPublicoAlvo("familias");
		arrecadacao.setQtdAlimentos(50);
		arrecadacao.setQtdBrinquedosRoupas(12);

//		arrecadacao.imprimirTipo();
		
		ArrecadacaoDao.incluir(arrecadacao);
		
		List<Arrecadacao> Lista = ArrecadacaoDao.obterLista();
		for (Arrecadacao a : Lista) {
			a.imprimirTipo();		
		}

	}

}
