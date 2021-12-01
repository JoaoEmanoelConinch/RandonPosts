package br.com.joao.postagems.model.enumeratiom.pessoa;

import java.io.Serializable;

public enum Genero implements Serializable {

	MASCULINO("masculino"), FEMININO("feminino");

	private String descricao;

	private Genero(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
