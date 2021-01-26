package com.springexample.onetomany.relationshipexample;

import com.springexample.onetomany.relationshipexample.entity.Comment;
import com.springexample.onetomany.relationshipexample.entity.Post;
import com.springexample.onetomany.relationshipexample.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class RelationshipExampleApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RelationshipExampleApplication.class, args);
	}

	@Autowired
	private PostRepository repository;

	@Override
	public void run(String... args) throws Exception {
		var comments = List.of(new Comment("comment1"),
				new Comment("comment2"), new Comment("comment3"));

		Post post = new Post("post1","post1",comments);

		repository.save(post);
	}
}
