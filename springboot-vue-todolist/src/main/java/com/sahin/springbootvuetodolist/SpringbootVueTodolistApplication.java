package com.sahin.springbootvuetodolist;

import com.sahin.springbootvuetodolist.model.Todo;
import com.sahin.springbootvuetodolist.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringbootVueTodolistApplication {

	private final TodoRepository repository;

	@PostConstruct
	void init() {

		repository.deleteAll();

		repository.saveAll(
				Arrays.asList(
						new Todo("dishes","wash the dishes",false),
						new Todo("homework","finish the homework",true),
						new Todo("mother","call the mother",false)
				)
		);

	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootVueTodolistApplication.class, args);
	}

}
