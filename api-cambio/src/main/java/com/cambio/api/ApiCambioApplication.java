package com.cambio.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication
@EnableJpaRepositories
public class ApiCambioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiCambioApplication.class, args);
	}

}
