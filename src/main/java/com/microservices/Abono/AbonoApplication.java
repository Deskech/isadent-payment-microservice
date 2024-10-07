package com.microservices.Abono;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

public class AbonoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbonoApplication.class, args);
	}

}
