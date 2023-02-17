package com.desafiobackend.attornatus.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.desafiobackend.attornatus.entities.Pessoa;
import com.desafiobackend.attornatus.repository.PessoaRepository;
import com.desafiobackend.attornatus.services.PessoaService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private PessoaService pessoaService;

	public PessoaController(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}

	// Endpoint para listar pessoas
	@GetMapping
	public List<Pessoa> findAll() {
		List<Pessoa> pessoas = pessoaRepository.findAll();
		return pessoas;
	}

	// Endpoint para buscar uma pessoa por ID
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<Optional<Pessoa>> buscarPessoaPorId(@PathVariable Long id) {
		Optional<Pessoa> pessoa = pessoaService.buscarPessoaPorId(id);
		if (pessoa != null) {
			return ResponseEntity.ok(pessoa);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Endpoint para criar uma pessoa
	@PostMapping
	public ResponseEntity<Pessoa> criarPessoa(@RequestBody Pessoa pessoa) {
		Pessoa novaPessoa = pessoaService.criarPessoa(pessoa);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novaPessoa.getId())
				.toUri();
		return ResponseEntity.created(uri).body(novaPessoa);
	}

	// Endpoint para deletar uma pessoa por ID
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarPessoa(@PathVariable Long id) {
		pessoaService.deletarPessoa(id);
		return ResponseEntity.noContent().build();
	}

	// Endopoint para atualizar pessoa
	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> atualizarPessoa(@PathVariable Long id, @RequestBody Pessoa pessoa) {
		Pessoa pessoaAtualizada = pessoaService.atualizarPessoa(id, pessoa);
		if (pessoaAtualizada != null) {
			return ResponseEntity.ok(pessoaAtualizada);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
