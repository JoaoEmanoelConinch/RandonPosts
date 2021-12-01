package br.com.joao.postagems.model.controler.pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.joao.postagems.model.dto.PessoaDto;
import br.com.joao.postagems.model.entity.pessoa.PessoaEntity;
import br.com.joao.postagems.model.mapper.PessoaMapper;
import br.com.joao.postagems.model.repository.pessoa.PessoaRepo;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaControler {
	
	@Autowired
	PessoaRepo pessoaRepo;
	
	@Autowired
	PessoaMapper pessoaMapper;
	
	@PostMapping
	public ResponseEntity<PessoaDto> post(@RequestBody PessoaDto pessoaDto){
		final PessoaEntity pessoaEntity = pessoaMapper.toPesso(pessoaDto);
		final PessoaDto pessoaDto2 = pessoaMapper.toDto(pessoaRepo.save(pessoaEntity));
		return ResponseEntity.ok().body(pessoaDto2);
	}

}
