package com.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
@ComponentScan(basePackages = "com.rest")
@EnableSwagger2
@SpringBootApplication
public class TestRestfulServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestRestfulServiceApplication.class, args);
	}

}
