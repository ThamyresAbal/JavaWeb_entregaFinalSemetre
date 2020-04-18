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
import negocio.PessoaFisica;
import negocio.PessoaJuridica;

public class PessoaFisicaDao {

	public static List<PessoaFisica> obterLista(){
		String sql = "SELECT * FROM TPessoaFisica ORDER BY usuario";
		
		List<PessoaFisica> lista = null;
		
		PreparedStatement ps = null;
		
		try {
			lista = new ArrayList<PessoaFisica>();
			
	ps = Conexao.obterConexao().prepareStatement(sql);
			
			ResultSet rs = null;
			
			rs = ps.executeQuery();
			
			Calendar dataNascimento = Calendar.getInstance();
			
						
			while(rs.next()){
				Date data = rs.getDate("dataNascimento");
				dataNascimento.setTime(data);
				
				
//				
//				PessoaFisica pf = new PessoaFisica();
//				// todos os atributos da filha e da mae
//		        
//				pf.setId(rs.getLong("id"));
//		        pf.setUsuario(rs.getString("usuario"));    
//				pf.setSenha(rs.getString("senha"));
//				
//				//filha
//		        
//				pf.setNome(rs.getString("nome"));
//				pf.setNomeSocial(rs.getString("nomeSocial"));
//				pf.setDataNascimento(dataNascimento);
//				pf.setCpf(rs.getString("cpf"));     
//				pf.setGenero(rs.getString("genero"));
//				
//				lista.add(pf);
				
				
				lista.add(
					new PessoaFisica(
							rs.getInt("id"), 
							rs.getString("usuario"), 
							rs.getString("senha"), 
							null,
							
							rs.getString("nome"), 
							rs.getString("nomeSocial"),
							dataNascimento,
							rs.getString("cpf"),
							rs.getString("Naturalidade"),
							rs.getString("Nacionalidade"),
							rs.getString("Genero"),
							rs.getString("EstadoCivil")
							));
			}
			
			return lista;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;		
	}
	
	public static boolean incluir(PessoaFisica pf){
		String sql = "INSERT INTO TPessoaFisica("
				+ "usuario,"
				+ "senha,"
				+ "nome, "
				+ "nomeSocial,"
				+ "dataNascimento,"
				+ "cpf,"
				+ "naturalidade,"
				+ "nacionalidade,"
				+ "genero,"
				+ "estadoCivil,"
				+ ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps = null;
		
		try {
			
			java.sql.Date dataConvertida = new java.sql.Date(
					pf.getDataNascimento().getTimeInMillis()
					);
			
					
			ps = Conexao.obterConexao().prepareStatement(sql);
			
			ps.setString(1, pf.getUsuario());
			ps.setString(2, pf.getSenha());
			ps.setString(3, pf.getNome());
			ps.setString(4, pf.getNomeSocial());
			ps.setDate(5, dataConvertida);
			ps.setString(6, pf.getCpf());
			ps.setString(7, pf.getNaturalidade());
			ps.setString(8, pf.getNacionalidade());
			ps.setString(9, pf.getGenero());
			ps.setString(10, pf.getEstadoCivil());
			
			ps.execute();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
    public static List<String> genero(){
		
		List <String> listaSexo = new ArrayList<String>();
    	
    	listaSexo.add("Masculino");
    	listaSexo.add("Feminino");
    	listaSexo.add("Outros");

    	return listaSexo;
	}
    
    public static List<String> naturalidade(){
		List <String> listaNaturalidade = new ArrayList<String>();
		 	
		listaNaturalidade.add("AC");
		listaNaturalidade.add("AL");
		listaNaturalidade.add("AM");
		listaNaturalidade.add("AP");
		listaNaturalidade.add("BA");
		listaNaturalidade.add("CE");
		listaNaturalidade.add("DF");
		listaNaturalidade.add("ES");
		listaNaturalidade.add("GO");
		listaNaturalidade.add("MA");
		listaNaturalidade.add("MG");
		listaNaturalidade.add("MS");
		listaNaturalidade.add("MT");
		listaNaturalidade.add("PA");
		listaNaturalidade.add("PB");
	    listaNaturalidade.add("PE");
        listaNaturalidade.add("PI");
        listaNaturalidade.add("PR");
        listaNaturalidade.add("RJ");
        listaNaturalidade.add("RN");
        listaNaturalidade.add("RO");
        listaNaturalidade.add("RR");
        listaNaturalidade.add("RS");
        listaNaturalidade.add("SC");
        listaNaturalidade.add("SE");
        listaNaturalidade.add("SP");
        listaNaturalidade.add("TO");
        		
        return listaNaturalidade;
	}
    public static List<String> estadoCivil(){
		
		List <String> listaEstadoCivil = new ArrayList<String>();
    	
    	listaEstadoCivil.add("Solteiro(a)");
    	listaEstadoCivil.add("Casado(a)");
    	listaEstadoCivil.add("Divorciado(a)");
    	listaEstadoCivil.add("Viúvo(a)");

    	return listaEstadoCivil;
	}

    public static boolean excluir(int id){
		String sql = "DELETE FROM TPessoaFisica WHERE id = ?";
		
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

	public static boolean alterar(PessoaFisica pf){
		String sql = "UPDATE TPessoaFisica SET "
										+ "usuario,"
										+ "senha,"
										+ "nome, "
										+ "nomeSocial,"
										+ "dataNascimento,"
										+ "cpf,"
										+ "cpf,"
										+ "naturalidade,"
										+ "nacionalidade,"
										+ "genero,"
										+ "estadoCivil,"
										+ ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) WHERE id = ?";
		
		PreparedStatement ps = null;
		
		try {
			
			java.sql.Date dataConvertida = new java.sql.Date(
					pf.getDataNascimento().getTimeInMillis()
					);
			
			
			ps = Conexao.obterConexao().prepareStatement(sql);
			
			ps.setString(1, pf.getUsuario());
			ps.setString(2, pf.getSenha());
			ps.setString(3, pf.getNome());
			ps.setString(4, pf.getNomeSocial());
			ps.setDate(5, dataConvertida);
			ps.setString(6, pf.getCpf());
			ps.setString(7, pf.getNaturalidade());
			ps.setString(8, pf.getNacionalidade());
			ps.setString(9, pf.getGenero());
			ps.setString(10, pf.getEstadoCivil());
			ps.setInt(11, pf.getId());

			
			ps.execute();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}	

	public static PessoaFisica obterPorId(int id) {
		String sql = "SELECT * FROM TPessoaFisica WHERE id = ?";
		
		PreparedStatement ps = null;
		
		try {			
			ps = Conexao.obterConexao().prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = null;
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				PessoaFisica pf = new PessoaFisica();
			
				pf.setUsuario(rs.getString("usuario"));
				pf.setSenha(rs.getString("senha"));
				pf.setNome(rs.getString("nome"));
				pf.setNomeSocial(rs.getString("nomeSocial"));
				pf.setCpf(rs.getString("cpf"));
				pf.setNaturalidade(rs.getString("naturalidade"));
				pf.setNacionalidade(rs.getString("nacionalidade"));
				pf.setGenero(rs.getString("genero"));
				pf.setEstadoCivil(rs.getString("EstadoCivil"));
				
				return pf;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;		
	}

}
