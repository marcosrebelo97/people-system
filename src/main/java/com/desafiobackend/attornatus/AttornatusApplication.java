package com.desafiobackend.attornatus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.desafiobackend.attornatus"}) // add this so the spring boot context knows where to look for entities

public class AttornatusApplication {

	public static void main(String[] args) {
		SpringApplication.run(AttornatusApplication.class, args);
	}

}
