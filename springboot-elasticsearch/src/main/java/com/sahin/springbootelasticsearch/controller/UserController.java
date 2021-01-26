package com.sahin.springbootelasticsearch.controller;

import com.sahin.springbootelasticsearch.entity.User;
import com.sahin.springbootelasticsearch.repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository repository;

    @PostConstruct
    public void initDB(){
        User user = new User("1","Sahin","Cayirli","Turkey", Calendar.getInstance().getTime());
        repository.save(user);
    }

    @GetMapping("/user/{search}")
    public ResponseEntity<List<User>> getUsers(@PathVariable String search){
        return ResponseEntity.ok(repository.findByFirstNameContaining(search));
    }



}
