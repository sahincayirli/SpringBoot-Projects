package com.sahin.springbootvue.controller;

import com.sahin.springbootvue.model.Friend;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@RestController
@RequestMapping("api/friends")
@CrossOrigin
public class FriendController {

    private Set<Friend> friends = Set.of(
            new Friend("Sahin", 15, "Istanbul"),
            new Friend("Emre", 20, "Izmir"),
            new Friend("Selim", 25, "Ankara")
    );

    @GetMapping
    public ResponseEntity<Set<Friend>> getFriends() {
        return ResponseEntity.ok(friends);
    }

    @GetMapping("{name}")
    public ResponseEntity<Friend> getFriend(@PathVariable String name) {
        return ResponseEntity.ok(friends.stream().filter( friend -> friend.getName().equals(name)).findFirst().orElse(new Friend()));
    }

}
