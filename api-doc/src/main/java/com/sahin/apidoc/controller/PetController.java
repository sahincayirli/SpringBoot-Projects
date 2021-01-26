package com.sahin.apidoc.controller;

import com.sahin.apidoc.dto.Pet;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

@RestController
@RequestMapping("/petshop")
@Api(value = "Pet API documentation")
public class PetController {

    private Set<Pet> pets = new HashSet<>();

    @PostConstruct
    public void init() {
        Stream.of(
                new Pet(1L, "Dog", Calendar.getInstance().getTime()),
                new Pet(2L, "Cat", Calendar.getInstance().getTime()),
                new Pet(3L,"Shark",Calendar.getInstance().getTime())
                ).forEach(val -> pets.add(val));
    }

    @PostMapping("/pet")
    @ApiOperation(value = "POST Pet")
    public ResponseEntity<Pet> createPet(@RequestBody @ApiParam(value = "This is a Pet") Pet pet) {
        pets.add(pet);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/pets")
    @ApiOperation(value = "GET PETS")
    public ResponseEntity<Set<Pet>> pets() {
        return ResponseEntity.ok().body(pets);
    }

}
