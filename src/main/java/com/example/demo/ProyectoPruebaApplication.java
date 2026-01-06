package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProyectoPruebaApplication {

	public static void main(String[] args) {
		var ctx = SpringApplication.run(ProyectoPruebaApplication.class, args);

		var myFirstClass = ctx.getBean("myFirstBean", MyFirstClass.class);

		System.out.println(myFirstClass.sayHello());
	}

}
