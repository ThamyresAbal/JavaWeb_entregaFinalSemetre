package negocio;

public class App {
	private String PessoaFisica;
	private String PessoaJuridica;
	
	public App() {
		
	}
	
	public App(String pessoaFisica, String pessoaJuridica) {
		this.setPessoaFisica(pessoaFisica);
		this.setPessoaJuridica(pessoaJuridica);
	}

	public String getPessoaFisica() {
		return PessoaFisica;
	}

	public void setPessoaFisica(String pessoaFisica) {
		PessoaFisica = pessoaFisica;
	}

	public String getPessoaJuridica() {
		return PessoaJuridica;
	}

	public void setPessoaJuridica(String pessoaJuridica) {
		PessoaJuridica = pessoaJuridica;
	}
	
	
	
	
	
	
}
