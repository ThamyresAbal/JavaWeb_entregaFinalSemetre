package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import conexao.Conexao;
import negocio.Arrecadacao;
import negocio.Contato;
import negocio.DoacaoMonetaria;

public class DoacaoMonetariaDao {
	public static List<DoacaoMonetaria> obterLista(){
		String sql = "SELECT * FROM TDoacaoMonetaria ORDER BY nomeAtividade";
		
		List<DoacaoMonetaria> lista = null;
		
		PreparedStatement ps = null;
		
		try {
			lista = new ArrayList<DoacaoMonetaria>();
			
			ps = Conexao.obterConexao().prepareStatement(sql);
			
			ResultSet rs = null;
			
			rs = ps.executeQuery();
			
			Calendar dataAtividade = Calendar.getInstance();
			Calendar hora = Calendar.getInstance();
			
			while(rs.next()){
				Date data = rs.getDate("dataAtividade");
				dataAtividade.setTime(data);
				
				Date horaFormat = rs.getDate("hora");
				hora.setTime(horaFormat);
		      
//		        DoacaoMonetaria doacao= new DoacaoMonetaria();
//				// todos os atributos da filha e da mae
//				
//				doacao.setId(rs.getInt("id"));
//				doacao.setNomeAtividade(rs.getString("nomeAtividade"));
//				doacao.setCategoria(rs.getString("categoria"));
//				doacao.setDataAtividade(dataAtividade);
//				doacao.setHora(hora);         
//				doacao.setDescricao(rs.getString("descricao"));     
//				doacao.setEndereco(null);     
//				doacao.setUsuario(null); 
//				
//				// atributos da filha 
//				doacao.setValorDoacao(rs.getFloat("valorDoacao"));           
//				doacao.setMetaArrecadacao(rs.getFloat("metaArrecadacao"));      
//				doacao.setValorArrecadado(rs.getFloat("valorArrecadacao"));
//				
//				lista.add(doacao);
//				
							
				lista.add(
					new DoacaoMonetaria(
						                            
						rs.getInt("id"),                                           
						rs.getString("nomeAtividade"),                   
						dataAtividade,
		//				hora,                      
						rs.getString("categoria"),          
						rs.getString("descricao"),
						null,						
						                                                           
						rs.getFloat("valorDoacao"),             
						rs.getFloat("metaArrecadacao"),     
						rs.getFloat("valorArrecadado")    
								)			
				);
			}
			
			return lista;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;		
	}
	

	public static boolean incluir(DoacaoMonetaria doacao){
		String sql = "INSERT INTO TDoacaoMonetaria ("
				+ "nomeAtividade,"
				+ "dataAtividade,"
//				+ "hora,"
				+ "categoria,"
				+ "descricao,"
				+ "valorDoacao,"
				+ "metaArrecadacao,"
				+ "valorArrecadado"
				+ ")VALUES (?, ?, ?, ?, ?, ?, ?, ? )";
		
			PreparedStatement ps = null;
		
		try {
			
			java.sql.Date dataConvertida = new java.sql.Date(
					doacao.getDataAtividade().getTimeInMillis()
					);
//			java.sql.Time horaConvertida = new java.sql.Time(
//					doacao.getHora().getTimeInMillis()
//					);
//					
			ps = Conexao.obterConexao().prepareStatement(sql);
			
			ps.setString(1, doacao.getNomeAtividade());
			ps.setDate(2, dataConvertida);
//			ps.setTime(3, horaConvertida);
			ps.setString(3, doacao.getCategoria());
			ps.setString(4, doacao.getDescricao());
			ps.setFloat(5, doacao.getValorDoacao());
			ps.setFloat(6, doacao.getMetaArrecadacao());
			ps.setFloat(7,doacao.getValorArrecadado());
			
			ps.execute();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	public static boolean excluir(int id){
		String sql = "DELETE FROM TDoacaoMonetaria WHERE id = ?";
		
		PreparedStatement ps = null;
		
		try {
			
			ps = Conexao.obterConexao().prepareStatement(sql);
			ps.setInt(1, id);
			
			ps.execute();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public static boolean alterar(DoacaoMonetaria doacao){
		String sql = "UPDATE TDoacaoMonetaria SET "
							+ "nomeAtividade,"
							+ "dataAtividade,"
			//				+ "hora,"
							+ "categoria,"
							+ "descricao,"
							+ "valorDoacao,"
							+ "metaArrecadacao,"
							+ "valorArrecadado"
							+ "VALUES (?, ?, ?, ?, ?, ?, ?, ? )  WHERE id = ?";
		
		PreparedStatement ps = null;
		
		try {
			
			java.sql.Date dataConvertida = new java.sql.Date(
					doacao.getDataAtividade().getTimeInMillis()
					);
//			java.sql.Time horaConvertida = new java.sql.Time(
//					doacao.getHora().getTimeInMillis()
//					);
			
			ps = Conexao.obterConexao().prepareStatement(sql);
			
			ps.setString(1, doacao.getNomeAtividade());
			ps.setDate(2, dataConvertida);
//			ps.setTime(3, horaConvertida);
			ps.setString(3, doacao.getCategoria());
			ps.setString(4, doacao.getDescricao());
			ps.setFloat(5, doacao.getValorDoacao());
			ps.setFloat(6, doacao.getMetaArrecadacao());
			ps.setFloat(7,doacao.getValorArrecadado());
			ps.setInt(8, doacao.getId());

			ps.execute();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}	

	public static DoacaoMonetaria obterPorId(int id) {
		String sql = "SELECT * FROM TDoacaoMonetaria WHERE id = ?";
		
		PreparedStatement ps = null;
		
		try {			
			ps = Conexao.obterConexao().prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = null;
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				DoacaoMonetaria doacao = new DoacaoMonetaria();
			
				doacao.setNomeAtividade(rs.getString("nomeAtividade"));
//				dataAtividade,
//				hora, 
				doacao.setCategoria(rs.getString("categoria"));
				doacao.setDescricao(rs.getString("descricao"));
				doacao.setValorDoacao(rs.getFloat("valorDoacao"));
				doacao.setMetaArrecadacao(rs.getFloat("metaArrecadacao"));
				doacao.setValorArrecadado(rs.getFloat("valorArrecadado"));
				
				return doacao;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;		
	}

}
