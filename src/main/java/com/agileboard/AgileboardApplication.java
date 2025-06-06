package com.agileboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
public class AgileboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgileboardApplication.class, args);
	}

	@PostConstruct
	public void started() {
		System.out.println("✅ Spring Boot inició completamente");
		
	}


}
