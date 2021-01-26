package com.springexamples.hellocoucbase.controller;

import com.springexamples.hellocoucbase.model.User;
import com.springexamples.hellocoucbase.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("couchbase")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createUser(@RequestBody User user) {

        repository.save(user);

        return String.format("%s created successfully",user.getName());
    }

    @GetMapping("users")
    @ResponseStatus(HttpStatus.OK)
    public List<User> users() {
        return repository.findAll();
    }


}
