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

		MyFirstService myFirstService = ctx.getBean(MyFirstService.class);

		System.out.println(myFirstService.tellAStory());
		// System.out.println(myFirstService.getJavaVersion());
		// System.out.println(myFirstService.getOsName());
		// System.out.println(myFirstService.getOsVersion());
		// System.out.println(myFirstService.readProps());
		System.out.println(myFirstService.readCustomEnvProps());
		// System.out.println(myFirstService.readCustomProps2());
		// System.out.println("Custom property as int: " + myFirstService.readCustomPropsInt());
	}

}
