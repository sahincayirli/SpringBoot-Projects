package com.sahin.restexample.controller;

import com.sahin.restexample.model.User;
import com.sahin.restexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/users")
    private List<User> getUsers(){
        return service.users();
    }

    @PostMapping("/users")
    private User createUser(@RequestBody User user){
        return service.createUser(user);
    }

    @DeleteMapping("/users/{id}")
    private ResponseEntity<Void> deleteUser(@PathVariable Long id){
        service.deleteUser(id);
        return ResponseEntity.ok().build();
    }

}
