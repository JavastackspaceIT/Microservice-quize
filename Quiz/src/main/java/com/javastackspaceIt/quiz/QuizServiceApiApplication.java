package com.javastackspaceIt.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class QuizServiceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizServiceApiApplication.class, args);
	}

}
