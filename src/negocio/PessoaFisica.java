package negocio;
import java.util.Calendar;

import auxiliar.Constante;

public class PessoaFisica extends Usuario {
	private String nome;
	private String nomeSocial;
	private Calendar dataNascimento;
	private String cpf;
	private String naturalidade;
	private String nacionalidade;
	private String genero;
	private String estadoCivil;
	
	public PessoaFisica() {
		       
		
	}
	
	public PessoaFisica(int id, String usuario, String senha, Contato contato,
			String nome, String nomeSocial, Calendar dataNascimento, String cpf, String naturalidade,
			String nacionalidade, String genero, String estadoCivil) {
		super(id,usuario, senha, contato);
		this.setNome(nomeSocial);            
		this.setNomeSocial(nomeSocial);   
		this.setDataNascimento(dataNascimento); 
		this.setCpf(cpf);          
		this.setNaturalidade(naturalidade);
		this.setNacionalidade(nacionalidade);
		this.setGenero(genero);
		this.setEstadoCivil(estadoCivil);
	}
		
		
	public void mostraGenero() {
		for (int i = 0; i < Constante.GENERO.length; i++) {
			System.out.println("Digite " + i + "para "+ Constante.GENERO[i]);
		}
	}
	
	public void escolhaGenero(int opcaoGeneroEscolhida) {
		this.genero = Constante.GENERO[opcaoGeneroEscolhida];
	}
	
	@Override
	//sobrescrevendo o método da mãe
	public void imprimirTipo() {
		//chamada da exibição da superclasse
		super.adicionarCabecalho();
	
		System.out.printf(":: Dados Pessoais ::\n"
				+ "Nome: %s \n"
				+ "Nome Social: %s \n"
				+ "Data de Nascimento (DD/MM/AA): %s \n"
				+ "CPF: %s \n"
				+ "Naturalidade: %s\n"
				+ "Nacionalidade: %s \n"
				+ "Genero: %s \n"
				+ "EstadoCivil: %s \n"				
				+ "Genero: %s\n",
				 this.getNome(),    
				 this.getNomeSocial(),   
				 Constante.obterDataFormatada(dataNascimento.getTime()), 
				 this.getCpf(),            
				 this.getNaturalidade(),
				 this.getNacionalidade(),
				 this.getGenero(),
				 this.getEstadoCivil());
		
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeSocial() {
		return nomeSocial;
	}

	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	
}
