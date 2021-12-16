package me.niv.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class BackendApplication {
	//Test
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}
