package com.springexample.relationship.manytomany;

import com.springexample.relationship.manytomany.entity.Post;
import com.springexample.relationship.manytomany.entity.Tag;
import com.springexample.relationship.manytomany.repository.PostRepository;
import com.springexample.relationship.manytomany.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.Set;

@SpringBootApplication
public class ManyToManyApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ManyToManyApplication.class, args);
	}

	@Autowired
	private PostRepository postRepository;


	@Override
	public void run(String... args) throws Exception {

		Post post = new Post("Hibernate Many to Many Mapping Example with Spring Boot",
				"Hibernate Many to Many Mapping Example with Spring Boot",
				"Hibernate Many to Many Mapping Example with Spring Boot");

		Post post1 = new Post("Hibernate One to Many Mapping Example with Spring Boot",
				"Hibernate One to Many Mapping Example with Spring Boot",
				"Hibernate One to Many Mapping Example with Spring Boot");

		Tag springBoot = new Tag("Spring Boot");
		Tag hibernate = new Tag("Hibernate");

		// add tag references post
		post.getTags().add(springBoot);
		post.getTags().add(hibernate);

		// add post references tag

		springBoot.getPosts().add(post);
		hibernate.getPosts().add(post);

		springBoot.getPosts().add(post1);
		post1.getTags().add(springBoot);


		this.postRepository.save(post);
		this.postRepository.save(post1);

	}
}
