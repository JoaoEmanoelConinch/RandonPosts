package br.com.joao.postagems.model.repository.pessoa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.joao.postagems.model.entity.pessoa.PessoaEntity;

@Repository
public interface PessoaRepo extends JpaRepository<PessoaEntity, Long>{

}
