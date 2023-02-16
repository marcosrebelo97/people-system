package com.desafiobackend.attornatus.repository;

import com.desafiobackend.attornatus.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa,Long> {
	
	
}
