package com.picranking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@SpringBootApplication
public class PicrankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(PicrankingApplication.class, args);
	}

}
