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

import dao.PessoaFisicaDao;
import negocio.PessoaFisica;
public class PessoaFisicaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private int id;
	private String operacao;
	
    public PessoaFisicaController() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		operacao = request.getParameter("operacao");
		id = request.getParameter("id") == null 
				? 0 
				: Integer.valueOf(request.getParameter("id"));
		
		request.setAttribute("pessoa", PessoaFisicaDao.obterPorId(id));
		
		request.getRequestDispatcher("pessoaFisicaDetalhe.jsp").forward(request, response);
				
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("listaNaturalidade", PessoaFisicaDao.naturalidade());
		request.setAttribute("listaSexo", PessoaFisicaDao.genero());
		request.setAttribute("listaEstadoCivil", PessoaFisicaDao.estadoCivil());
		
		PessoaFisica pessoaFisica = null;
		
		switch (operacao) {
		case "Incluir":			
			pessoaFisica = obterPessoaFisica(request, response);
			PessoaFisicaDao.incluir(pessoaFisica);
			break;

		case "Alterar":
			pessoaFisica = obterPessoaFisica(request, response);
			pessoaFisica.setId(id);
			PessoaFisicaDao.alterar(pessoaFisica);
			break;

		case "Excluir":		
			PessoaFisicaDao.excluir(id);
			break;

		default:
			break;
		}
		
		request.setAttribute("lista", PessoaFisicaDao.obterLista());
		
		request.getRequestDispatcher("pessoaFisicaLista.jsp").forward(request, response);

	}
	private PessoaFisica obterPessoaFisica(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PessoaFisica pf = new PessoaFisica();
	
        pf.setUsuario(request.getParameter("usuario"));    
		pf.setSenha(request.getParameter("senha"));
		pf.setNome(request.getParameter("nome"));
		pf.setNomeSocial(request.getParameter("nomeSocial"));
//		pf.setDataNascimento(request.getParameter("dataNascimento");
		pf.setCpf(request.getParameter("cpf"));     
		pf.setGenero(request.getParameter("genero"));
		
		Calendar dtData = Calendar.getInstance();    		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");        
        try {
        	Date data = (Date)df.parse(request.getParameter("DataNascimento"));            
            dtData.setTime(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}         		
		pf.setDataNascimento(dtData);
	
		return pf;
	}

}
