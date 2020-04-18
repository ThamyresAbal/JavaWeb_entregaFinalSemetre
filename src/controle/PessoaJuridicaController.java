package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PessoaJuridicaDao;
import negocio.PessoaJuridica;
public class PessoaJuridicaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String operacao;
	
    public PessoaJuridicaController() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		operacao = request.getParameter("operacao");
		id = request.getParameter("id") == null 
				? 0 
				: Integer.valueOf(request.getParameter("id"));
				
		request.setAttribute("pessoa", PessoaJuridicaDao.obterPorId(id));
		
		request.getRequestDispatcher("pessoaJuridicaDetalhe.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PessoaJuridica pJu = null;
		
		switch (operacao) {
		case "Incluir":			
			pJu = obterPessoaJuridica(request, response);
			PessoaJuridicaDao.incluir(pJu);
			break;

		case "Alterar":
			pJu = obterPessoaJuridica(request, response);
			pJu.setId(id);
			PessoaJuridicaDao.alterar(pJu);
			break;

		case "Excluir":		
			PessoaJuridicaDao.excluir(id);
			break;

		default:
			break;
		}
		
		request.setAttribute("lista", PessoaJuridicaDao.obterLista());
		
		request.getRequestDispatcher("pessoaJuridicaLista.jsp").forward(request, response);

	}
	private PessoaJuridica obterPessoaJuridica(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PessoaJuridica pJu = new PessoaJuridica();
		pJu.setUsuario(request.getParameter("usuario"));
		pJu.setSenha(request.getParameter("senha"));
		pJu.setNomeEmpresa(request.getParameter("nomeEmpresa"));
		pJu.setRazaoSocial(request.getParameter("razaoSocial"));
		pJu.setCnpj(request.getParameter("cnpj"));
	
		return pJu;
	}

}
