package negocio;

import interfaces.IExibido;

public class Contato implements IExibido {
	private int id;
	private String email;
	private String telefone;
	private String celular;

//Contrutor padrão
	public Contato() {

	}

	public Contato(int id, String email, String telefone, String celular) {
		this.setId(id);
		this.setEmail(email);
		this.setTelefone(telefone);
		this.setCelular(celular) ;
	}

	public void divulgar() {
		System.out.printf(":: Contato :: \n "
				+ "Email: %s \n"
				+ "Telefone:%s \n"
				+ "Celular: %s \n",
				this.getEmail(), 
				this.getTelefone(), 
				this.getCelular()
				);
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
