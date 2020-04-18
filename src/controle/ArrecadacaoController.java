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

import dao.ArrecadacaoDao;
import negocio.Arrecadacao;
public class ArrecadacaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String operacao;
	
    public ArrecadacaoController() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 id = request.getParameter("id") == null 
				? 0 
				: Integer.valueOf(request.getParameter("id"));
		
		request.setAttribute("arrecadacao", ArrecadacaoDao.obterPorId(id));
		
		request.getRequestDispatcher("arrecadacaoDetalhe.jsp").forward(request, response);
					
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Arrecadacao arrecadacao= null;
		
		switch (operacao) {
		case "Incluir":			
			arrecadacao = obterArrecadacao(request, response);
			ArrecadacaoDao.incluir(arrecadacao);
			break;

		case "Alterar":
			arrecadacao = obterArrecadacao(request, response);
			arrecadacao.setId(id);
			ArrecadacaoDao.alterar(arrecadacao);
			break;

		case "Excluir":		
			ArrecadacaoDao.excluir(id);
			break;

		default:
			break;
		}
		
		request.setAttribute("lista", ArrecadacaoDao.obterLista());
		
		request.getRequestDispatcher("arrecadacaoLista.jsp").forward(request, response);

	}
	
	private Arrecadacao  obterArrecadacao (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Arrecadacao a = new Arrecadacao();
		
		a.setNomeAtividade(request.getParameter("nomeAtividade"));
//hora
		a.setCategoria(request.getParameter("categoria"));
		a.setDescricao(request.getParameter("descricao"));
		a.setQtdParticipantes(Integer.valueOf(request.getParameter("qtdParticipantes")));
		a.setQtdAlimentos(Integer.valueOf(request.getParameter("qtdAlimentos")));
		a.setMetaArrecadacao(Float.valueOf(request.getParameter("metaArrecadacao")));
		a.setPublicoAlvo(request.getParameter("publicoAlvo"));
		a.setQtdBrinquedosRoupas(Integer.valueOf(request.getParameter("qtdBrinquedosRoupas")));
		

		Calendar dtData = Calendar.getInstance();    		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");        
        try {
        	Date data = (Date)df.parse(request.getParameter("dataAtividade"));            
            dtData.setTime(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}         		
        a.setDataAtividade(dtData);
        
		return a;
	}

}
