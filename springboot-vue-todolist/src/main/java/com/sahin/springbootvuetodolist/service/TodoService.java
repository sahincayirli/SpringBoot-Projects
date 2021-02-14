package com.sahin.springbootvuetodolist.service;

import com.sahin.springbootvuetodolist.model.Todo;
import com.sahin.springbootvuetodolist.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository repository;

    public List<Todo> getTodos() {
        return repository.findAll();
    }

    public Todo getTodo(String id) {
        return repository.findById(id).orElse(null);
    }

    public Todo addTodo(Todo todo) {
        return repository.save(todo);
    }

    public void removeTodo(String id) {
        repository.deleteById(id);
    }

    public Todo doTodo(String id) {
        Todo todo = getTodo(id);
        todo.setDone(true);
        return repository.save(todo);
    }

}
