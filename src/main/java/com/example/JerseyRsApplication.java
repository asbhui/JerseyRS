package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.config.JerseyConfig;

@SpringBootApplication
@Import(JerseyConfig.class)
@EnableJpaRepositories("com.example")
public class JerseyRsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JerseyRsApplication.class, args);
	}
}
