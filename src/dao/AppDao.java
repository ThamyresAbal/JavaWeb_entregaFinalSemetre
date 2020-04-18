package dao;

import java.util.List;

import negocio.Arrecadacao;
import negocio.Contato;
import negocio.DoacaoMonetaria;
import negocio.Endereco;
import negocio.Oficina;
import negocio.PessoaFisica;
import negocio.PessoaJuridica;

public class AppDao {
		
	public static List<?> obterLista(String lista) {
	
		//deve existir quantos cases forem necessários para contemplar todas as suas telas de lista
		switch (lista){
		case "arrecadacaoLista.jsp":
			return ArrecadacaoDao.obterLista();

		case "contatoLista.jsp":
			return ContatoDao.obterLista();
			
		case "doacaoMonetariaLista.jsp":
			return DoacaoMonetariaDao.obterLista();
		
		case "enderecoLista.jsp":
			return EnderecoDao.obterLista();
		
		case "oficinaLista.jsp":
			return OficinaDao.obterLista();
			
		case "pessoaFisicaLista.jsp":
			return PessoaFisicaDao.obterLista();
			
		case "pessoaJuridicaLista.jsp":
			return PessoaJuridicaDao.obterLista();
		default:
			break;
		}
		
		return null;
		
	}
		
}		
		
//		if("arrecadacaoLista.jsp".equals(lista)) {
//			return (List<Arrecadacao>)ArrecadacaoDao.obterLista();
//		} else if("contatoLista.jsp".equals(lista)) {
//			return (List<Contato>)ContatoDao.obterLista();
//		} else if("doacaoMonetariaLista.jsp".equals(lista)) {
//			return (List<DoacaoMonetaria>)DoacaoMonetariaDao.obterLista();
//		} else if("enderecoLista.jsp".equals(lista)) {
//			return (List<Endereco>)EnderecoDao.obterLista();
//		} else if("oficinaLista.jsp".equals(lista)) {
//			return (List<Oficina>)OficinaDao.obterLista();
//		} else if("pessoaFisicaLista.jsp".equals(lista)) {
//			return (List<PessoaFisica>)PessoaFisicaDao.obterLista();
//		}else if("pessoaJuridicaLista.jsp".equals(lista)) {
//			return (List<PessoaJuridica>)PessoaJuridicaDao.obterLista();
//		}else {
//		return null;
//		}

