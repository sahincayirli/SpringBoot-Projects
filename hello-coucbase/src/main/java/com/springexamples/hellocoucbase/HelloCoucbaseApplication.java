package com.springexamples.hellocoucbase;

import com.springexamples.hellocoucbase.model.User;
import com.springexamples.hellocoucbase.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
@RequiredArgsConstructor
public class HelloCoucbaseApplication {

	private final UserRepository repository;

	@PostConstruct
	private void init() {

		repository.saveAll(
				Arrays.asList(
                        new User(1L,25,"Sahin Cayirli",new String[] {"Emre","Selim"}),
                        new User(2L,24,"Sahin Cayirli",new String[] {"Recep","Ahmet"})
                )
		);

	}

	public static void main(String[] args) {
		SpringApplication.run(HelloCoucbaseApplication.class, args);
	}

}
