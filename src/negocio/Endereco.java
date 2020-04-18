package negocio;

import interfaces.IExibido;

public class Endereco implements IExibido{
	private int id;
	private String rua;	
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	private String cep;
	
	public Endereco() {
		
	}

	
	public Endereco(int id, String rua, String complemento, String bairro, String cidade, String uf, String cep) {
		this.setId(id);
		this.setRua (rua);
		this.setComplemento(complemento);
		this.setBairro(bairro);
		this.setCidade(cidade);
		this.setUf(uf);
		this.setCep(cep);
		
	}
	
	public void divulgar() {
		System.out.printf(":: Endereço da atividade ::"
				+ "\n CEP: %s\n"
				+ " %s, %s - %s, %s - %s\n",
				this.getCep(),
				this.getRua(),
				this.getComplemento(),
				this.getBairro(),
				this.getCidade(),
				this.getUf()
				);
	}
	
// Entrada e Saída de dados		
	
	public String getRua() {
		return rua;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

}
