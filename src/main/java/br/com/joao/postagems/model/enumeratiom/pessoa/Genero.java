package br.com.joao.postagems.model.enumeratiom.pessoa;

public enum Genero {

	MASCULINO("masculino"),
	FEMININO("feminino");
	
	private String descricao;
	
	private Genero(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}
