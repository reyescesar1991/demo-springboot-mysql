package com.example.demo;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoPruebaApplication {

	public static void main(String[] args) {

		var app = new SpringApplication(ProyectoPruebaApplication.class);

		app.setDefaultProperties(
			Collections.singletonMap("spring.profiles.active", "dev")
		);

		var ctx = app.run(args);

	}

}
