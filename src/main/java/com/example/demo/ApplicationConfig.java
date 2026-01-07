package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class ApplicationConfig {

    @Bean
    @Qualifier("bean1")
    MyFirstClass myFirstBean(){
        return new MyFirstClass("My first bean");
    }

    @Bean
    @Qualifier("bean2")
    MyFirstClass mySecondBean(){
        return new MyFirstClass("My second bean");
    }

    @Bean
    @Primary
    MyFirstClass myThirdBean(){
        return new MyFirstClass("My third bean");
    }

}
