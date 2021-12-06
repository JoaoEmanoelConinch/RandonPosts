package br.com.joao.postagems.model.entity.pessoa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.joao.postagems.model.enumeratiom.pessoa.Genero;

@Entity
public class PessoaEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private Byte idade;

	@Column(nullable = false)
	private String senha;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Genero genero;

	public PessoaEntity() {
	}

	public PessoaEntity(Long id, String nome, Byte idade, String senha, Genero genero) {
		this.setId(id);
		this.setNome(nome);
		this.setIdade(idade);
		this.setSenha(senha);
		this.setGenero(genero);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Byte getIdade() {
		return idade;
	}

	public void setIdade(Byte idade) {
		this.idade = idade;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
