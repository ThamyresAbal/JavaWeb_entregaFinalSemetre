package negocio;

import java.util.Calendar;
import java.util.List;

import auxiliar.Constante;

public abstract class Atividade {
	private int id;
	private String nomeAtividade;
	private Calendar dataAtividade;//Calendar é uma classe do java assim como String
	//private Calendar hora;
	private String categoria;
	private String descricao;
	private Endereco endereco;
	private List <Usuario> usuario;
	
	public Atividade() {
		
	}
	
	public Atividade(int id, String nomeAtividade, Calendar dataAtividade,
			 String categoria, String descricao, Endereco endereco) {
		this.setId(id);
		this.setNomeAtividade(nomeAtividade);
		this.setDataAtividade(dataAtividade);
//		this.setHora(hora);
		this.setCategoria(categoria);
		this.setDescricao(descricao);
		this.setEndereco(endereco);
	
	}

	
	// Método para percorrer o vetor para mostrar as opcões.
	public void mostraCategoriaAtividade() {
		//percorre o vetor
		for(int i = 0; i < Constante.CATEGORIA.length; i++) { 
			//printa as opções de acordo com a posição de i no vetor
			System.out.println("Digite " + i + "para " + Constante.CATEGORIA[i]); 
		}
	}
	
	//lendo a opção escolhida 
	public void escolhaCategoriaAtividade(int opcaoCategoriaEscolhida) {
		//jogando a opcao escolhida (vetor) no atributo
		this.categoria = Constante.CATEGORIA[opcaoCategoriaEscolhida];
	}

	public void divulgar() {
		System.out.printf("Nome da Atividade: %s \n" 
				+ "Data: %s \n" 
		//		+ "Hora:%s \n"
				+ "Categoria: %s \n" 
				+ "Descrição: %s \n", 
				this.getNomeAtividade(), 
				Constante.obterDataFormatada(dataAtividade.getTime()), 
			//	Constante.obterHoraFormatada(hora.getTime()), 
				this.getCategoria(),
				this.getDescricao()
				);
		
	//	endereco.divulgar();
		
		}

	//força as filhas a implementarem o mesmo método
	// adicionarCabecalho será chamado dentro de imprimirTipo
	public abstract void imprimirTipo();
	
	//protected não pode ser acessado fora do pacote a não ser em casos de herança
	//final é para não ser sobrescrito
	protected final void adicionarCabecalho() {
		System.out.println("# Atividade #");
		
		divulgar();
	}
	
	public String getNomeAtividade() {
		return nomeAtividade;
	}

	public void setNomeAtividade(String nomeAtividade) {
		this.nomeAtividade = nomeAtividade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getDataAtividade() {
		return dataAtividade;
	}

	public void setDataAtividade(Calendar dataAtividade) {
		this.dataAtividade = dataAtividade;
	}
//
//	public Calendar getHora() {
//		return hora;
//	}
//
//	public void setHora(Calendar hora) {
//		this.hora = hora;
//	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List <Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List <Usuario> usuario) {
		this.usuario = usuario;
	}

	
}
