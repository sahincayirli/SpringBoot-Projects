package com.sahin.springbootvuetodolist.controller;

import com.sahin.springbootvuetodolist.model.Todo;
import com.sahin.springbootvuetodolist.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("todo")
public class TodoController {

    private final TodoService service;

    @GetMapping("all")
    public ResponseEntity<List<Todo>> getTodos() {
        return ResponseEntity.ok(service.getTodos());
    }

    @PostMapping
    public ResponseEntity<Todo> addTodo(@RequestBody Todo todo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addTodo(todo));
    }

    @PutMapping("{id}")
    public ResponseEntity<Todo> doTodo(@PathVariable String id) {
        return ResponseEntity.ok(service.doTodo(id));
    }

    @GetMapping("{id}")
    public ResponseEntity<Todo> getTodo(@PathVariable String id) {
        return ResponseEntity.ok(service.getTodo(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> removeTodo(@PathVariable String id) {
        service.removeTodo(id);
        return ResponseEntity.ok("Removed Successfully");
    }

}
