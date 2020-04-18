package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import conexao.Conexao;
import negocio.Arrecadacao;
import negocio.Atividade;
import negocio.Usuario;

public class ArrecadacaoDao {

	public static List<Arrecadacao> obterLista(){
		String sql = "SELECT * FROM TArrecadacao ORDER BY nomeAtividade";
		
		List<Arrecadacao> lista = null;
		
		PreparedStatement ps = null;
		
		try {
			lista = new ArrayList<Arrecadacao>();
			
			ps = Conexao.obterConexao().prepareStatement(sql);
			
			ResultSet rs = null;
			
			rs = ps.executeQuery();
			
			Calendar dataAtividade = Calendar.getInstance();
			Calendar hora = Calendar.getInstance();
						
			while(rs.next()){
				Date data = rs.getDate("dataAtividade");
				dataAtividade.setTime(data);
				
//				Date horaFormat = rs.getDate("hora");
//				hora.setTime(horaFormat);
				
//				//tratamento de data
//				Calendar dtInscricao = Calendar.getInstance();
//				dtInscricao.setTime(rs.getDate("dataAtividade"));	
//				
//				//tratamento de hora
//				Calendar dt = Calendar.getInstance();
//				dtInscricao.setTime(rs.getTime("inscricao"));	
				
				lista.add(
					new Arrecadacao(
	                                                   
						rs.getInt("id"),                                           
						rs.getString("nomeAtividade"),                   
						dataAtividade,
//						hora,                      
						rs.getString("categoria"),          
						rs.getString("descricao"),
						null,
						
						rs.getInt("qtdParticipantes"),      							
						rs.getInt("qtdAlimentos"),        
						rs.getFloat("metaArrecadacao"),     
						rs.getString("publicoAlvo"),        
						rs.getInt("qtdBrinquedosRoupas")  
				                                                              
					)
				);
			}
			
			return lista;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;		
	}
	

	public static boolean incluir(Arrecadacao arrecadacao){
		String sql = "INSERT INTO TArrecadacao("
				+ "nomeAtividade,"
				+ "dataAtividade,"
				+ "hora,"
				+ "categoria,"
				+ "descricao,"
				+ "qtdParticipantes,"
				+ "qtdAlimentos,"
				+ "metaArrecadacao,"
				+ "publicoAlvo,"
				+ "qtdBrinquedosRoupas"
				+ ") VALUES (?, ?, ?, ?, ?, ?, ?, ?,?,?)";
		
			PreparedStatement ps = null;
		
		try {
			
			java.sql.Date dataConvertida = new java.sql.Date(
					arrecadacao.getDataAtividade().getTimeInMillis()
					);
//			java.sql.Time horaConvertida = new java.sql.Time(
//					arrecadacao.getHora().getTimeInMillis()
//					);
					
			ps = Conexao.obterConexao().prepareStatement(sql);
			
			ps.setString(1, arrecadacao.getNomeAtividade());
			ps.setDate(2, dataConvertida);
//			ps.setTime(3, horaConvertida);
			ps.setString(3, arrecadacao.getCategoria());
			ps.setString(4, arrecadacao.getDescricao());
			ps.setInt(5, arrecadacao.getQtdParticipantes());
			ps.setFloat(6, arrecadacao.getQtdAlimentos());
			ps.setFloat(7, arrecadacao.getMetaArrecadacao());
			ps.setString(8, arrecadacao.getPublicoAlvo());
			ps.setInt(9, arrecadacao.getQtdBrinquedosRoupas());
			
			ps.execute();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static boolean excluir(int id){
		String sql = "DELETE FROM TArrecadacao WHERE id = ?";
		
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

	public static boolean alterar(Arrecadacao arrecadacao){
		String sql = "UPDATE TArrecadacao SET "
								+ "nomeAtividade,"
								+ "dataAtividade,"
	//							+ "hora," 
								+ "categoria,"
								+ "descricao,"
								+ "qtdParticipantes,"
								+ "qtdAlimentos,"
								+ "metaArrecadacao,"
								+ "publicoAlvo,"
								+ "qtdBrinquedosRoupas"
								+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)  WHERE id = ?";
		
		PreparedStatement ps = null;
		
		try {
			
			java.sql.Date dataConvertida = new java.sql.Date(
					arrecadacao.getDataAtividade().getTimeInMillis()
					);
//			java.sql.Time horaConvertida = new java.sql.Time(
//					arrecadacao.getHora().getTimeInMillis()
//					);
			
			ps = Conexao.obterConexao().prepareStatement(sql);
			
			ps.setString(1, arrecadacao.getNomeAtividade());
			ps.setDate(2, dataConvertida);
//			ps.setTime(3, horaConvertida);
			ps.setString(3, arrecadacao.getCategoria());
			ps.setString(4, arrecadacao.getDescricao());
			ps.setInt(5, arrecadacao.getQtdParticipantes());
			ps.setFloat(6, arrecadacao.getQtdAlimentos());
			ps.setFloat(7, arrecadacao.getMetaArrecadacao());
			ps.setString(8, arrecadacao.getPublicoAlvo());
			ps.setInt(9, arrecadacao.getQtdBrinquedosRoupas());
			ps.setInt(10, arrecadacao.getId());

			ps.execute();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}	

	public static Arrecadacao obterPorId(int id) {
		String sql = "SELECT * FROM TArrecadacao WHERE id = ?";
		
		PreparedStatement ps = null;
		
		try {			
			ps = Conexao.obterConexao().prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = null;
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				Arrecadacao a = new Arrecadacao();
			
				a.setNomeAtividade(rs.getString("nomeAtividade"));
//				dataAtividade,
//				hora, 
				a.setCategoria(rs.getString("categoria"));
				a.setDescricao(rs.getString("descricao"));
				a.setQtdParticipantes(rs.getInt("qtdParticipantes"));
				a.setQtdAlimentos(rs.getInt("qtdAlimentos"));
				a.setMetaArrecadacao(rs.getFloat("metaArrecadacao"));
				a.setPublicoAlvo(rs.getString("publicoAlvo"));
				a.setQtdBrinquedosRoupas(rs.getInt("qtdBrinquedosRoupas"));
			
				return a;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;		
	}

}
