package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContatoDao;
import negocio.Contato;
public class ContatoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private int id;
	private String operacao;
	
	public ContatoController() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		operacao = request.getParameter("operacao");
		
		 id = request.getParameter("id") == null 
				? 0 
				: Integer.valueOf(request.getParameter("id"));
		
		request.setAttribute("contato", ContatoDao.obterPorId(id));
				
		request.getRequestDispatcher("contatoDetalhe.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Contato contato= null;
		
		switch (operacao) {
		case "Incluir":			
			contato = obterContato(request, response);
			ContatoDao.incluir(contato);
			break;

		case "Alterar":
			contato = obterContato(request, response);
			contato.setId(id);
			ContatoDao.alterar(contato);
			break;

		case "Excluir":		
			ContatoDao.excluir(id);
			break;

		default:
			break;
		}
		request.setAttribute("lista", ContatoDao.obterLista());
		
		request.getRequestDispatcher("contatoLista.jsp").forward(request, response);
	}
	private Contato obterContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Contato c = new Contato();
		
		c.setEmail(request.getParameter("email"));
 		c.setTelefone(request.getParameter("telefone"));
		c.setCelular(request.getParameter("celular"));
	
		return c;
	
	}

}
