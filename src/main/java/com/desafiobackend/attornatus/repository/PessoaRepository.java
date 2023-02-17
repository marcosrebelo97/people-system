package com.desafiobackend.attornatus.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafiobackend.attornatus.entities.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Optional<Pessoa> findById(Long id);

    List<Pessoa> findAll();

    Pessoa save(Pessoa pessoa);

    void delete(Pessoa pessoa);
}
