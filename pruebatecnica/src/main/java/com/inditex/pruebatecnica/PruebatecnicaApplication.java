package com.inditex.pruebatecnica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PruebatecnicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebatecnicaApplication.class, args);
	}

}
