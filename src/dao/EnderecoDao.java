package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import conexao.Conexao;
import negocio.Arrecadacao;
import negocio.Endereco;
import negocio.Oficina;

public class EnderecoDao {
	public static List<Endereco> obterLista(){
		String sql = "SELECT * FROM TEndereco ORDER BY rua";
		
		List<Endereco> lista = null;
		
		PreparedStatement ps = null;
		
		try {
			lista = new ArrayList<Endereco>();
			
			ps = Conexao.obterConexao().prepareStatement(sql);
			
			ResultSet rs = null;
			
			rs = ps.executeQuery();
			
						
			while(rs.next()){

				lista.add(
					new Endereco(
							rs.getInt("id"),               
							rs.getString("rua"),      
							rs.getString("complemento"),
					        rs.getString("bairro"),
					        rs.getString("cidade"),
					        rs.getString("uf"),
							rs.getString("cep")
					        )
					);
					
			}
			
			return lista;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;		
	}
		
	public static boolean incluir(Endereco endereco){
		String sql = "INSERT INTO TEndereco(rua, complemento, bairro, cidade, uf, cep)"
				+ " VALUES (?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps = null;
		
		try {
			
			ps = Conexao.obterConexao().prepareStatement(sql);
			
			ps.setString(1, endereco.getRua());
			ps.setString(2, endereco.getComplemento());
			ps.setString(3, endereco.getBairro());
			ps.setString(4, endereco.getCidade());
			ps.setString(5, endereco.getUf());
			ps.setString(6, endereco.getCep());
			
			ps.execute();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public static List<String> naturalidade(){
		List <String> listaUf = new ArrayList<String>();
		 	
		listaUf.add("AC");
		listaUf.add("AL");
		listaUf.add("AM");
		listaUf.add("AP");
		listaUf.add("BA");
		listaUf.add("CE");
		listaUf.add("DF");
		listaUf.add("ES");
		listaUf.add("GO");
		listaUf.add("MA");
		listaUf.add("MG");
		listaUf.add("MS");
		listaUf.add("MT");
		listaUf.add("PA");
		listaUf.add("PB");
	    listaUf.add("PE");
        listaUf.add("PI");
        listaUf.add("PR");
        listaUf.add("RJ");
        listaUf.add("RN");
        listaUf.add("RO");
        listaUf.add("RR");
        listaUf.add("RS");
        listaUf.add("SC");
        listaUf.add("SE");
        listaUf.add("SP");
        listaUf.add("TO");
        		
        return listaUf;
	}

	public static boolean excluir(int id){
		String sql = "DELETE FROM TEndereco WHERE id = ?";
		
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

	public static boolean alterar(Endereco endereco){
		String sql = "UPDATE TEndereco SET (rua, complemento, bairro, cidade, uf, cep)"
				+ " VALUES (?, ?, ?, ?, ?, ?)  WHERE id = ?";
		
		PreparedStatement ps = null;
		
		try {
			
						
			ps = Conexao.obterConexao().prepareStatement(sql);
			
			ps.setString(1, endereco.getRua());
			ps.setString(2, endereco.getComplemento());
			ps.setString(3, endereco.getBairro());
			ps.setString(4, endereco.getCidade());
			ps.setString(5, endereco.getUf());
			ps.setString(6, endereco.getCep());
			ps.setInt(7, endereco.getId());

			
			ps.execute();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}	

	public static Endereco obterPorId(int id) {
		String sql = "SELECT * FROM TEndereco WHERE id = ?";
		
		PreparedStatement ps = null;
		
		try {			
			ps = Conexao.obterConexao().prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = null;
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				Endereco endereco = new Endereco();
				
				endereco.setRua(rs.getString("rua"));
				endereco.setComplemento(rs.getString("complemento"));
				endereco.setBairro(rs.getString("bairro"));
				endereco.setCidade(rs.getString("cidade"));
				endereco.setUf(rs.getString("uf"));
				endereco.setCep(rs.getString("cep"));
				
				return endereco;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;		
	}


}