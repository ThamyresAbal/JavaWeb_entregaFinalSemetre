package negocio;

import java.util.List;

public abstract class Usuario {
	private int id;
	private String usuario;
	private String senha;
	private Contato contato;
	private List <Atividade> atividade;
		
	public Usuario() {
		
	}
	
	public Usuario(int id,String usuario, String senha, Contato contato) {
		this.setId(id);
		this.setUsuario(usuario);
		this.setSenha(senha);
		this.setContato(contato);
	}
	
	public void divulgar() {
		System.out.printf(":: Cadastro ::\n "
				+ "Usuário: %s \n "
				+ "Senha: %s \n",
				this.getUsuario(),
				this.getSenha()
				);	
		//contato.divulgar();
	}

	// forca as filhas implementarem o mesmo método
	//adicionarCabecalho será chamado dentro de imprimirTipo
	public abstract void imprimirTipo();
	
	//protected não pode ser acessado fora do pacote a não ser em casos de herança
	//final é para não ser sobrescrito
	protected final void adicionarCabecalho() {
		System.out.println("# Usuário #");
		//chama o metodo da própria classe
		divulgar();
	}
	

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Atividade> getAtividade() {
		return atividade;
	}

	public void setAtividade(List<Atividade> atividade) {
		this.atividade = atividade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
