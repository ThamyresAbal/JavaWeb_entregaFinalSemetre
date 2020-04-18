package negocio;

public class PessoaJuridica extends Usuario {
	private String nomeEmpresa;
	private String razaoSocial;
	private String cnpj;

	public PessoaJuridica() {
		
	}
	
	public PessoaJuridica(int id, String usuario, String senha, Contato contato,
			String nomeEmpresa,String razaoSocial,String cnpj ) {
		super(id,usuario, senha, contato);
		this.setNomeEmpresa(nomeEmpresa);
		this.setRazaoSocial(razaoSocial);
		this.setCnpj(cnpj);
		
	}
	
	@Override
	//sobrescrevendo
	public void imprimirTipo() {
		//chamando a exibição da mãe
		super.adicionarCabecalho();
		
		System.out.printf(":: Dados da empresa ::\n"
				+ "Nome da empresa: %s \n"
				+ "Razao Social: %s \n"
				+ "CNPJ: %s \n",
				this.getNomeEmpresa(),
				this.getRazaoSocial(),
				this.getCnpj()
				);	
	}
	
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}
	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
}
