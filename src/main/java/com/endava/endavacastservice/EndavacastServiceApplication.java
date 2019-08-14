package com.endava.endavacastservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.endava")
@EnableJpaRepositories("com.endava.repository")
@EntityScan("com.endava.model")
public class EndavacastServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EndavacastServiceApplication.class, args);
	}

}
