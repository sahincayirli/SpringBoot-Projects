package com.sahin.expensetracker.service;

import com.sahin.expensetracker.model.Category;
import com.sahin.expensetracker.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public Collection<Category> categories() {
        return repository.findAll();
    }

    public Optional<Category> category(Long id) {
        return repository.findById(id);
    }

    public Category createCategory(Category category){
        return repository.save(category);
    }

    public void deleteCategory(Long id){
        repository.deleteById(id);
    }
}
