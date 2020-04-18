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

public class ContatoDao {
	public static List<Contato> obterLista(){
		String sql = "SELECT * FROM TContato ORDER BY email";
		
		List<Contato> lista = null;
		
		PreparedStatement ps = null;
			
		try {
			lista = new ArrayList<Contato>();
			
			ps = Conexao.obterConexao().prepareStatement(sql);
			
			ResultSet rs = null;
			
			rs = ps.executeQuery();
			
						
			while(rs.next()){
					
//		        Contato contato = new Contato();
//		        
//		        contato.setId(rs.getInt("id"));
//				contato.setEmail(rs.getString("email"));
//				contato.setTelefone(rs.getString("telefone"));
//				contato.setCelular(rs.getString("celular"));
//				
//				lista.add(contato);
		        
		        
				// feito assim pq tenho um construtor em Contato que recebe todos os atributos
				lista.add(
					new Contato(
							rs.getInt("id"),               
							rs.getString("email"),      
							rs.getString("telefone"),
					        rs.getString("celular")
					        )
					);
					
			}
			
			return lista;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;		
	}
	

	public static boolean incluir(Contato contato){
		String sql = "INSERT INTO TContato(email, telefone, celular) VALUES (?, ?, ?)";
		
		PreparedStatement ps = null;
		
		try {
			
			ps = Conexao.obterConexao().prepareStatement(sql);
			
			ps.setString(1, contato.getEmail());
			ps.setString(2, contato.getTelefone());
			ps.setString(3, contato.getCelular());
			
			ps.execute();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public static boolean excluir(int id){
		String sql = "DELETE FROM TContato WHERE id = ?";
		
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

	public static boolean alterar(Contato contato){
		String sql = "UPDATE TContato SET email=? , telefone=?, celular=? WHERE id = ?";
		
		PreparedStatement ps = null;
		
		try {
				
			ps = Conexao.obterConexao().prepareStatement(sql);
			
			ps.setString(1, contato.getEmail());
			ps.setString(2, contato.getTelefone());
			ps.setString(3, contato.getCelular());
			ps.setInt(4, contato.getId());
			
			ps.execute();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}	

	public static Contato obterPorId(int id) {
		String sql = "SELECT * FROM TContato WHERE id = ?";
		
		PreparedStatement ps = null;
		
		try {			
			ps = Conexao.obterConexao().prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = null;
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				Contato contato = new Contato();
				
				contato.setEmail(rs.getString("email"));
				contato.setTelefone(rs.getString("telefone"));
				contato.setCelular(rs.getString("celular"));

			
				return contato;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;		
	}

}
