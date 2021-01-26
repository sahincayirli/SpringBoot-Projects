package com.sahin.postgresqldatajparest.controller;

import com.sahin.postgresqldatajparest.dto.PersonDTO;
import com.sahin.postgresqldatajparest.service.ımpl.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService service;

    @GetMapping("/persons")
    public ResponseEntity persons(){
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping("/person")
    public ResponseEntity createPerson(@RequestBody PersonDTO personDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(personDTO));
    }


}
