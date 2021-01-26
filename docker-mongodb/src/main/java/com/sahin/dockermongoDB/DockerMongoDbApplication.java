package com.sahin.dockermongoDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class DockerMongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerMongoDbApplication.class, args);
	}

}
