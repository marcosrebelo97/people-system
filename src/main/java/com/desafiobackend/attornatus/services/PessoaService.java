package com.desafiobackend.attornatus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiobackend.attornatus.entities.Pessoa;
import com.desafiobackend.attornatus.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public Optional<Pessoa> buscarPessoaPorId(Long id) {
		return pessoaRepository.findById(id);
	}

	public List<Pessoa> listarPessoas() {
		return null;
	}

	public Pessoa criarPessoa(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	public void deletarPessoa(Long id) {
		pessoaRepository.deleteById(id);
	}

	public Pessoa atualizarPessoa(Long id, Pessoa pessoa) {
		Optional<Pessoa> pessoaOptional = pessoaRepository.findById(id);
		if (pessoaOptional.isPresent()) {
			Pessoa pessoaExistente = pessoaOptional.get();
			pessoaExistente.setNome(pessoa.getNome());
			pessoaExistente.setDataDeNascimento(pessoa.getDataDeNascimento());
			pessoaExistente.setEndereco(pessoa.getEndereco());
			return pessoaRepository.save(pessoaExistente);
		} else {
			throw new RuntimeException("Pessoa não encontrada");
		}
	}

}
