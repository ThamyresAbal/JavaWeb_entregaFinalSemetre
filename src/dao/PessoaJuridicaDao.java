package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import negocio.PessoaJuridica;

public class PessoaJuridicaDao {
	public static List<PessoaJuridica> obterLista(){
		String sql = "SELECT * FROM TPessoaJuridica ORDER BY usuario";
		
		List<PessoaJuridica> lista = null;
		
PreparedStatement ps = null;
		
		try {
			lista = new ArrayList<PessoaJuridica>();
			
			ps = Conexao.obterConexao().prepareStatement(sql);
			
			ResultSet rs = null;
			
			rs = ps.executeQuery();
			
								
			while(rs.next()){
//								
//				PessoaJuridica pj = new PessoaJuridica();
//				// todos os atributos da filha e da mae
//		        
//				pj.setId(rs.getInt("id"));
//		        pj.setUsuario(rs.getString("usuario"));    
//				pj.setSenha(rs.getString("senha"));
//				
//				pj.setNomeEmpresa(rs.getString("nomeEmpresa"));
//				pj.setRazaoSocial(rs.getString("razaoSocial"));
//				pj.setCnpj(rs.getString("cnpj"));     
//								
//				lista.add(pj);
				
				lista.add(
					new PessoaJuridica(
							rs.getInt("id"), 
							rs.getString("usuario"), 
							rs.getString("senha"), 
							null,
							rs.getString("nomeEmpresa"), 
							rs.getString("razaoSocial"),
							rs.getString("cnpj")
							)
				);
			}
			
			return lista;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;		
	}
	
	public static boolean incluir(PessoaJuridica pj){
		String sql = "INSERT INTO TPessoaJuridica("
				+ "usuario, "
				+ "senha,"
				+ "nomeEmpresa,"
				+ "razaoSocial,"
				+ "cnpj"
				+ ") VALUES (?, ?, ?, ?, ?)";
		
		PreparedStatement ps = null;
		
		try {
			
			ps = Conexao.obterConexao().prepareStatement(sql);
			
			ps.setString(1, pj.getUsuario());
			ps.setString(2, pj.getSenha());
			ps.setString(3, pj.getNomeEmpresa());
			ps.setString(4, pj.getRazaoSocial());
			ps.setString(5, pj.getCnpj());
			
			ps.execute();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	public static boolean excluir(int id){
		String sql = "DELETE FROM TPessoaJuridica WHERE id = ?";
		
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

	public static boolean alterar(PessoaJuridica pJu){
		String sql = "UPDATE TPessoaJuridica SET "
									+ "usuario, "
									+ "senha,"
									+ "nomeEmpresa,"
									+ "razaoSocial,"
									+ "cnpj"
									+ " VALUES (?, ?, ?, ?, ?)  WHERE id = ?";
							
		PreparedStatement ps = null;
		
		try {
			
						
			ps = Conexao.obterConexao().prepareStatement(sql);
			
			ps.setString(1, pJu.getUsuario());
			ps.setString(2, pJu.getSenha());
			ps.setString(3, pJu.getNomeEmpresa());
			ps.setString(4, pJu.getRazaoSocial());
			ps.setString(5, pJu.getCnpj());
			ps.setInt(6, pJu.getId());

			
			ps.execute();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}	

	public static PessoaJuridica obterPorId(int id) {
		String sql = "SELECT * FROM TPessoaJuridica WHERE id = ?";
		
		PreparedStatement ps = null;
		
		try {			
			ps = Conexao.obterConexao().prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = null;
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				PessoaJuridica pJu = new PessoaJuridica();
			
				pJu.setUsuario(rs.getString("usuario"));
				pJu.setSenha(rs.getString("senha"));
				pJu.setNomeEmpresa(rs.getString("nomeEmpresa"));
				pJu.setRazaoSocial(rs.getString("razaoSocial"));
				pJu.setCnpj(rs.getString("cnpj"));
			
				return pJu;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;		
	}

}
