package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AppDao;
public class AppController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AppController() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String tela = request.getParameter("tela");
		
		//essa linha é algo novo se comparado ao trecho de código que implementamos hoje.
		//o AppDao deve ser criado para que esse trecho funcione corretamente
		request.setAttribute("lista", AppDao.obterLista(tela));
		
		request.getRequestDispatcher(tela).forward(request, response);		
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
