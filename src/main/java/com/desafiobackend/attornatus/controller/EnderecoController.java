package com.desafiobackend.attornatus.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.desafiobackend.attornatus.entities.Endereco;
import com.desafiobackend.attornatus.services.EnderecoService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

	private EnderecoService enderecoService;

	// Endpoint para listar todos os endereços
	@GetMapping
	public ResponseEntity<List<Endereco>> listarEnderecos() {
		List<Endereco> enderecos = enderecoService.listarEnderecos();
		return ResponseEntity.ok(enderecos);
	}

	// Endpoint para criar um endereço
	@PostMapping
	public ResponseEntity<Endereco> criarEndereco(@RequestBody Endereco endereco) {
		Endereco novoEndereco = enderecoService.criarEndereco(endereco);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novoEndereco.getId())
				.toUri();
		return ResponseEntity.created(uri).body(novoEndereco);
	}

	// Endpoint para deletar um endereço
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarEndereco(@PathVariable Long id) {
		boolean sucesso = enderecoService.deletarEndereco(id);
		if (sucesso) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Endpoint para atualizar um endereço
	@PutMapping("/{id}")
	public ResponseEntity<Endereco> atualizarEndereco(@PathVariable Long id, @RequestBody Endereco endereco) {
		Endereco enderecoAtualizado = enderecoService.atualizarEndereco(id, endereco);
		if (enderecoAtualizado != null) {
			return ResponseEntity.ok(enderecoAtualizado);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
