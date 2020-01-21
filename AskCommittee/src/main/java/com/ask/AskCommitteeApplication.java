package com.ask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.ask")
@EntityScan("com.ask.entity")
@EnableJpaRepositories("com.ask.repository")
public class AskCommitteeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AskCommitteeApplication.class, args);
	}
}