package negocio;

import java.util.Calendar;

public class Arrecadacao extends Atividade {
	private int qtdParticipantes;
	private float qtdAlimentos;
	private float metaArrecadacao;
	private String publicoAlvo;
	private int qtdBrinquedosRoupas;
		
	public Arrecadacao() {
	
	}
	
	
	public Arrecadacao(int id, String nomeAtividade, Calendar dataAtividade,
			 String categoria, String descricao,
			Endereco endereco, int qtdParticipantes, 
			float qtdAlimentos, float metaArrecadacao, String publicoAlvo,
			int qtdBrinquedosRoupas) {
		
		super(id, nomeAtividade, dataAtividade, categoria, descricao, endereco);
		this.setQtdParticipantes(qtdParticipantes);
		this.setQtdAlimentos(qtdAlimentos);
		this.setMetaArrecadacao(metaArrecadacao);
		this.setPublicoAlvo(publicoAlvo);
		this.setQtdBrinquedosRoupas(qtdBrinquedosRoupas);
	}

	
	@Override
	public void imprimirTipo() {
		super.adicionarCabecalho();
		System.out.printf(":: Doações e Serviços ::\n "
		+"Quantidade de doadores:%d \n" 
		+ "Quantidades de alimentos arrecadados até o momento: %.2f kg \n"
		+ "Meta de arrecadação: %.2f\n"
		+ "Publico alvo: %s\n"
		+"Quantidade de pessoas a receberem brinquedos/roupas: %.2f \n",
		this.getQtdParticipantes(),
		this.getQtdAlimentos(),
		this.getMetaArrecadacao(),
		this.getPublicoAlvo(),
		this.getQtdAlimentos()
		
		);
	}
	
	
	

	public int getQtdParticipantes() {
		return qtdParticipantes;
	}


	public void setQtdParticipantes(int qtdParticipantes) {
		this.qtdParticipantes = qtdParticipantes;
	}


	public float getQtdAlimentos() {
		return qtdAlimentos;
	}


	public void setQtdAlimentos(float qtdAlimentos) {
		this.qtdAlimentos = qtdAlimentos;
	}


	public float getMetaArrecadacao() {
		return metaArrecadacao;
	}


	public void setMetaArrecadacao(float metaArrecadacao) {
		this.metaArrecadacao = metaArrecadacao;
	}


	public String getPublicoAlvo() {
		return publicoAlvo;
	}

	public void setPublicoAlvo(String publicoAlvo) {
		this.publicoAlvo = publicoAlvo;
	}

	public int getQtdBrinquedosRoupas() {
		return qtdBrinquedosRoupas;
	}

	public void setQtdBrinquedosRoupas(int qtdBrinquedosRoupas) {
		this.qtdBrinquedosRoupas = qtdBrinquedosRoupas;
	}


	
	

}
