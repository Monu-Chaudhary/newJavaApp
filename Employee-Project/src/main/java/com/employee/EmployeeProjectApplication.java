package com.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class EmployeeProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeProjectApplication.class, args);
	}

	@Bean
	public WebClient webClient() {
		return WebClient.builder().build();
	}

}
