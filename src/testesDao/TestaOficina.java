package testesDao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import dao.OficinaDao;
import negocio.Endereco;
import negocio.Oficina;

public class TestaOficina {

	public static void main(String[] args) {
		
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
        
		Oficina oficina = new Oficina();
		oficina.setNomeAtividade("Mais Atividades teatrais");
		oficina.setDataAtividade(dataAtividade);
		oficina.setHora(hora);
		oficina.setCategoria("Artes");
		oficina.setDescricao("Curso de teatro com Abílio Ramos");
		oficina.setQtdParticipantes(20);
//		oficina.setEndereco(end);
		
		OficinaDao.incluir(oficina);
		
		List<Oficina> Lista = OficinaDao.obterLista();
		for (Oficina o : Lista) {
			o.imprimirTipo();		
		}

	}

}
