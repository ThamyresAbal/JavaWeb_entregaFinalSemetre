package negocio;

import java.util.Calendar;

public class DoacaoMonetaria extends Atividade{ // heranca
	private float valorDoacao;
	private float metaArrecadacao;
	private float valorArrecadado;
	
	public DoacaoMonetaria() {
		// TODO Auto-generated constructor stub
	}
	
	public DoacaoMonetaria(int id, String nomeAtividade, Calendar dataAtividade,
			 String categoria, String descricao, Endereco endereco, float valorDoacao, float metaArrecadacao, float valorArrecadado) {
		super(id, nomeAtividade, dataAtividade, categoria, descricao, endereco);
		this.setValorDoacao(valorDoacao);
		this.setMetaArrecadacao(metaArrecadacao);
		this.setValorArrecadado(valorArrecadado);
	}
	  
			
	

	private float calcularValorArrecadado() {
		valorDoacao  = valorArrecadado + valorDoacao;
		return valorArrecadado;
	}
	public void verificarMeta() {
		if (calcularValorArrecadado() >= metaArrecadacao ) {
			System.out.printf("Atingimos a meta! Nosso muito obrigado (a)!");
			
		} else {
			System.out.println("Obrigada pela doação!");
		}
	}

	
	@Override
	public void imprimirTipo() {
		
		super.adicionarCabecalho();
		
		System.out.printf(":: Doação ::\n "
				+ "Valor doação: %.2f\n"
				+ "Meta de arrecadação: %.2f\n"
				+ "Valor Arrecadado: %.2f\n",
				this.getValorDoacao(),
				this.getMetaArrecadacao(),
				this.getValorArrecadado()
				);
	}


	public float getValorDoacao() {
		return valorDoacao;
	}
	public void setValorDoacao(float valorDoacao) {
		this.valorDoacao = valorDoacao;
	}
	public float getMetaArrecadacao() {
		return metaArrecadacao;
	}
	public void setMetaArrecadacao(float metaArrecadacao) {
		this.metaArrecadacao = metaArrecadacao;
	}
	public float getValorArrecadado() {
		return valorArrecadado;
	}
	public void setValorArrecadado(float valorArrecadado) {
		this.valorArrecadado = valorArrecadado;
	}

	
	
}
