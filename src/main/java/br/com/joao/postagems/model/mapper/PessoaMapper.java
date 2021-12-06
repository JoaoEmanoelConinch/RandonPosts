package br.com.joao.postagems.model.mapper;

import org.springframework.stereotype.Service;

import br.com.joao.postagems.model.dto.PessoaDto;
import br.com.joao.postagems.model.entity.pessoa.PessoaEntity;

@Service
public class PessoaMapper {

	public PessoaDto toDto(PessoaEntity pessoaEntity) {
		PessoaDto pessoaDto = new PessoaDto();
		pessoaDto.nome = pessoaEntity.getNome();
		pessoaDto.idade = pessoaEntity.getIdade();
		pessoaDto.senha = pessoaEntity.getSenha();
		pessoaDto.genero = pessoaEntity.getGenero();
		
		return pessoaDto;
	}
	
	public PessoaEntity toPesso(PessoaDto pessoaDto) {
		PessoaEntity pessoaEntity = new PessoaEntity();
		pessoaEntity.setNome(pessoaDto.nome);
		pessoaEntity.setIdade(pessoaDto.idade);
		pessoaEntity.setSenha(pessoaDto.senha);
		pessoaEntity.setGenero(pessoaDto.genero);
		
		return pessoaEntity;
	}
	
}
