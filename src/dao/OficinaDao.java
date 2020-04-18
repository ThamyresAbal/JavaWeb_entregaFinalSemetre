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
import negocio.DoacaoMonetaria;
import negocio.Endereco;
import negocio.Oficina;

public class OficinaDao {
	public static List<Oficina> obterLista(){
		String sql = "SELECT * FROM TOficina ORDER BY nomeAtividade";
		
		List<Oficina> lista = null;
		
		PreparedStatement ps = null;
		
				
		try {
			lista = new ArrayList<Oficina>();
			
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
				
//		      
//		        Oficina oficina = new Oficina();
//				// todos os atributos da filha e da mae
//				
//				oficina.setId(rs.getInt("id"));
//				oficina.setNomeAtividade(rs.getString("nomeAtividade"));
//				oficina.setCategoria(rs.getString("categoria"));
//				oficina.setDataAtividade(dataAtividade);
//				oficina.setHora(hora);         
//				oficina.setDescricao(rs.getString("descricao"));     
//				oficina.setEndereco(null);     
//				oficina.setUsuario(null); 
//				
//				// atributos da filha 
//				oficina.setQtdParticipantes(rs.getInt("qtdParticipantes")); 
//		        
//				oficina.setListaParticipantes(rs.getString("listaParticipantes"));
//				
//				lista.add(oficina);
				
				
				lista.add(
					new Oficina(
						                            
						rs.getInt("id"),                                           
						rs.getString("nomeAtividade"),                   
						dataAtividade,
		//				hora,                      
						rs.getString("categoria"),          
						rs.getString("descricao"),
						null,
												                                                           
						rs.getInt("qtdParticipantes")          
						//rs.getString("listaParticipantes")       
						)
				);
			}
			
			return lista;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;		
	}
	

	public static boolean incluir(Oficina oficina){
		String sql = "INSERT INTO TOficina("
				+ "nomeAtividade,"
				+ "dataAtividade,"
		//		+ "hora,"
				+ "categoria,"
				+ "descricao,"
				+ "qtdParticipantes"
//				+ "listaParticipantes"
				+ ") VALUES (?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps = null;
		
		try {
			
			ps = Conexao.obterConexao().prepareStatement(sql);
			
			java.sql.Date dataConvertida = new java.sql.Date(
					oficina.getDataAtividade().getTimeInMillis()
					);
//			java.sql.Date horaConvertida = new java.sql.Date(
//					oficina.getHora().getTimeInMillis()
//					);
			
			ps.setString(1, oficina.getNomeAtividade());
			ps.setDate(2, dataConvertida);
	//		ps.setDate(3, horaConvertida);
			ps.setString(3, oficina.getCategoria());
			ps.setString(4, oficina.getDescricao());
			ps.setInt(5, oficina.getQtdParticipantes());
//			ps.setString(7, oficina.getListaParticipantes());
			
			ps.execute();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public static boolean excluir(int id){
		String sql = "DELETE FROM TOficina WHERE id = ?";
		
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

	public static boolean alterar(Oficina oficina){
		String sql = "UPDATE TOficina SET "
							+ "nomeAtividade,"
							+ "dataAtividade,"
						//	+ "hora,"
							+ "categoria,"
							+ "descricao,"
							+ "qtdParticipantes"
			//				+ "listaParticipantes"
							+ ") VALUES (?, ?, ?, ?, ?, ?)  WHERE id = ?";
					
		PreparedStatement ps = null;
		
		try {
			
			java.sql.Date dataConvertida = new java.sql.Date(
					oficina.getDataAtividade().getTimeInMillis()
					);
//			java.sql.Time horaConvertida = new java.sql.Time(
//					oficina.getHora().getTimeInMillis()
//					);
			
			ps = Conexao.obterConexao().prepareStatement(sql);
			
			ps.setString(1, oficina.getNomeAtividade());
			ps.setDate(2, dataConvertida);
	//		ps.setTime(3, horaConvertida);
			ps.setString(3, oficina.getCategoria());
			ps.setString(4, oficina.getDescricao());
			ps.setInt(5, oficina.getQtdParticipantes());
//			ps.setString(7, oficina.getListaParticipantes());
			ps.setInt(6, oficina.getId());

			
			ps.execute();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}	

	public static Oficina obterPorId(int id) {
		String sql = "SELECT * FROM TOficina WHERE id = ?";
		
		PreparedStatement ps = null;
		
		try {			
			ps = Conexao.obterConexao().prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = null;
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				Oficina oficina = new Oficina();
			
				oficina.setNomeAtividade(rs.getString("nomeAtividade"));
//				dataAtividade,
//				hora, 
				oficina.setCategoria(rs.getString("categoria"));
				oficina.setDescricao(rs.getString("descricao"));
				oficina.setQtdParticipantes(rs.getInt("qtdParticipantes"));
			
				
				return oficina;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;		
	}


}
