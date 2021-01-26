package com.sahin.springsecurityjwt2.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

    @RequestMapping("/helloUser")
    public String helloUser() {
        return "Hello User";
    }

    @RequestMapping("/helloAdmin")
    public String helloAdmin() {
        return "Hello Admin";
    }

}
