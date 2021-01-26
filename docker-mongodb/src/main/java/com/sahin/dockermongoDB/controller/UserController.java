package com.sahin.dockermongoDB.controller;

import com.sahin.dockermongoDB.entity.User;
import com.sahin.dockermongoDB.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository repository;

    @PostConstruct
    public void initDB() {
        User user = new User("id","sahin","cayirli");
        repository.save(user);
    }

    @PostMapping("createUser")
    public ResponseEntity<User> createUser(@RequestBody User user){
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(location).body(repository.save(user));
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> users(){
       return ResponseEntity.ok(repository.findAll());
    }

    @PutMapping("/updateUser")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        return ResponseEntity.ok(repository.save(user));
    }

}
