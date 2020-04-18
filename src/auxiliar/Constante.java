package auxiliar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Constante {
	public final static String[] GENERO = {"Feminino", "Masculino", "Outros"};
	
	public final static String[] CATEGORIA = {"Artes Marciais", "Artesanato", "Teatro", "Música","Ajuda"}; 
	
	public static String obterDataFormatada(Date data) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
        return df.format(data);
	}
	
	public static String obterHoraFormatada(Date data) {
		DateFormat df = new SimpleDateFormat("hh:mm");
		
        return df.format(data);
	}

}
