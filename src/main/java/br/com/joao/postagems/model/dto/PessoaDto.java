package br.com.joao.postagems.model.dto;

import java.io.Serializable;

import br.com.joao.postagems.model.enumeratiom.pessoa.Genero;

public class PessoaDto implements Serializable {

	public String nome;
	public Byte idade;
	public Genero genero;
	public String senha;

}
