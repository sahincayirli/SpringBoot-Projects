package com.springexample.relationship.onetoone;

import com.springexample.relationship.onetoone.entity.Gender;
import com.springexample.relationship.onetoone.entity.User;
import com.springexample.relationship.onetoone.entity.UserProfile;
import com.springexample.relationship.onetoone.repository.UserProfileRepository;
import com.springexample.relationship.onetoone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class OneToOneApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OneToOneApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserProfileRepository userProfileRepository;

	@Override
	public void run(String... args) throws Exception {
		User user = new User("Sahin","sahin@gmail.com");
		UserProfile userProfile = new UserProfile("5312643502","ISTANBUL", Gender.MALE,LocalDate.now());

		user.setUserProfile(userProfile);
		userProfile.setUser(user);

		userRepository.save(user);
		userProfileRepository.save(userProfile);
	}
}
