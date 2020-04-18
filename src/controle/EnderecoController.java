package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EnderecoDao;
import negocio.Endereco;

public class EnderecoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   
	private int id;
	private String operacao;
		
    public EnderecoController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		operacao = request.getParameter("operacao");
		id = request.getParameter("id") == null 
				? 0 
				: Integer.valueOf(request.getParameter("id"));
		
		request.setAttribute("endereco", EnderecoDao.obterPorId(id));
		
		request.getRequestDispatcher("enderecoDetalhe.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("listaNaturalidade", EnderecoDao.obterLista());

		Endereco endereco = null;
		
		switch (operacao) {
		case "Incluir":			
			endereco = obterEndereco(request, response);
			EnderecoDao.incluir(endereco);
			break;

		case "Alterar":
			endereco = obterEndereco(request, response);
			endereco.setId(id);
			EnderecoDao.alterar(endereco);
			break;

		case "Excluir":		
			EnderecoDao.excluir(id);
			break;

		default:
			break;
		}
		
		request.setAttribute("lista", EnderecoDao.obterLista());
		
		request.getRequestDispatcher("enderecoLista.jsp").forward(request, response);

	}
	
	private Endereco obterEndereco(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Endereco endereco = new Endereco();
        
		endereco.setRua(request.getParameter("rua"));
		endereco.setComplemento(request.getParameter("complemento"));
		endereco.setBairro(request.getParameter("bairro"));
        endereco.setCidade(request.getParameter("cidade"));
        endereco.setUf(request.getParameter("uf"));
        endereco.setCep(request.getParameter("cep"));

	
		return endereco;
	}

}
