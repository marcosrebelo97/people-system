package com.desafiobackend.attornatus.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.desafiobackend.attornatus.entities.Endereco;
import com.desafiobackend.attornatus.repository.EnderecoRepository;

public class EnderecoService {

	private EnderecoRepository enderecoRepository;

	@Autowired
	public EnderecoService(EnderecoRepository enderecoRepository) {
		this.enderecoRepository = enderecoRepository;
	}

	public List<Endereco> listarEnderecos() {
		return null;
	}

	public Endereco criarEndereco(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}

	public boolean deletarEndereco(Long id) {
		enderecoRepository.deleteById(id);
		return false;
	}

	public Endereco atualizarEndereco(Long id, Endereco endereco) {
		return null;
	}

}
