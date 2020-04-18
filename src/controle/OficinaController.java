package controle;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OficinaDao;
import negocio.Oficina;
public class OficinaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private int id;
	private String operacao;

    public OficinaController() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		operacao = request.getParameter("operacao");
		id = request.getParameter("id") == null 
				? 0 
				: Integer.valueOf(request.getParameter("id"));
		
		request.setAttribute("oficina", OficinaDao.obterPorId(id));
		
		request.getRequestDispatcher("oficinaDetalhe.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Oficina oficina = null;
		
		switch (operacao) {
		case "Incluir":			
			oficina = obterOficina(request, response);
			OficinaDao.incluir(oficina);
			break;

		case "Alterar":
			oficina = obterOficina(request, response);
			oficina.setId(id);
			OficinaDao.alterar(oficina);
			break;

		case "Excluir":		
			OficinaDao.excluir(id);
			break;

		default:
			break;
		}
		
		request.setAttribute("lista", OficinaDao.obterLista());
		
		request.getRequestDispatcher("oficinaLista.jsp").forward(request, response);
	}

	private Oficina obterOficina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Oficina oficina = new Oficina();
			
		oficina.setNomeAtividade(request.getParameter("nomeAtividade"));
		oficina.setCategoria(request.getParameter("categoria"));
       
		oficina.setDescricao(request.getParameter("descricao"));     
		
		Calendar dtData = Calendar.getInstance();    		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");        
        try {
        	Date data = (Date)df.parse(request.getParameter("dataAtividade"));            
            dtData.setTime(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}         		
        oficina.setDataAtividade(dtData);
	
		return oficina;
	}
	
}
