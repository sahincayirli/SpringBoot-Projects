package com.sahin.expensetracker.controller;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import com.sahin.expensetracker.model.Category;
import com.sahin.expensetracker.repository.CategoryRepository;
import com.sahin.expensetracker.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping("/categories")
    private Collection<Category> categories() {
        return service.categories();
    }

    @GetMapping("/category/{id}")
    private ResponseEntity<?> getCategory(@PathVariable Long id) {
        Optional<Category> result = service.category(id);
        return result.map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/category")
    private ResponseEntity<Category> createCategory(@RequestBody Category category) throws URISyntaxException {
        Category result = service.createCategory(category);
        return ResponseEntity.created(new URI("/api/category" + result.getId())).body(result);
    }

    @PutMapping("/category/{id}")
    private ResponseEntity<Category> updateCategory(@RequestBody Category category) {
        Category result = service.createCategory(category);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/category/{id}")
    private ResponseEntity<?> deleteCategory(@PathVariable Long id){
        service.deleteCategory(id);
        return ResponseEntity.ok().build();
    }


}
