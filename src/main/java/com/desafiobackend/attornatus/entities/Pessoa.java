package com.desafiobackend.attornatus.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JoinColumn(name = "nome")
	private String nome;
	
	@JoinColumn(name = "datanascimento")
	private LocalDate dataDeNascimento;

	@ManyToOne
	@JoinColumn(name = "endereco_id", referencedColumnName = "id")
	private Endereco endereco;
}
