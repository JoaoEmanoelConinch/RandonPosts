package br.com.joao.postagems.model.entity.pessoa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.joao.postagems.model.enumeratiom.pessoa.Genero;

@Entity
public class PessoaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private Byte idade;
	
	@Column(nullable = false)
	private Genero genero;
	
	public PessoaEntity() {}
	
	public PessoaEntity(Long id, String nome, Byte idade, Genero genero) {
		this.setId(id);
		this.setNome(nome);
		this.setIdade(idade);
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
}
