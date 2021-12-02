package br.com.joao.postagems.model.controler.pessoa;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PutMapping (value = "/{id}")
	public ResponseEntity<PessoaDto> put(@PathVariable(value = "id") long id ,
			@RequestBody PessoaDto pessoaDto){
		final PessoaEntity newPessoa = pessoaMapper.toPesso(pessoaDto);
		Optional<PessoaEntity> oldPessoa = pessoaRepo.findById(id);
		if(oldPessoa.isPresent()) {
			PessoaEntity pessoaEntity = oldPessoa.get();
			newPessoa.setNome(pessoaEntity.getNome());
			newPessoa.setIdade(pessoaEntity.getIdade());
			newPessoa.setGenero(pessoaEntity.getGenero());
			
			return ResponseEntity.ok().body(pessoaMapper.toDto(newPessoa));
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping
	public ResponseEntity<List<PessoaDto>> get(){
		List<PessoaEntity> pessoas = pessoaRepo.findAll();
		List<PessoaDto> pessoasDto = pessoas.stream()
		.map(pessoaMapper::toDto)
		.collect(Collectors.toList());
		
		return ResponseEntity.ok().body(pessoasDto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PessoaDto> getById(@PathVariable(value = "id") long id){
		var pessoa = pessoaRepo.findById(id);
		if(pessoa.isPresent()) {
			return ResponseEntity.ok().body(pessoaMapper.toDto(pessoa.get()));
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}
