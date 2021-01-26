package com.sahin.restexample.service;

import com.sahin.restexample.model.User;
import com.sahin.restexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> users(){
        return repository.findAll();
    }

    public User createUser(User user){
        return repository.save(user);
    }

    public void deleteUser(Long id){
        repository.deleteById(id);
    }
}
