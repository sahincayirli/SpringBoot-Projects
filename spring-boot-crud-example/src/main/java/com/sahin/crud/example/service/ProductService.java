package com.sahin.crud.example.service;

import com.sahin.crud.example.entity.Product;
import com.sahin.crud.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ProductService implements EntityServiceTemplate<Product>{

    @Autowired
    ProductRepository repository;


    @Override
    public Product get(int id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @Override
    public Collection<Product> getAll() {
        return repository.findAll();
    }

    @Override
    public Product update(Product entity) {
        var exist = get(entity.getId());
        exist.setName(entity.getName());
        exist.setQuantity(entity.getQuantity());
        exist.setPrice(entity.getPrice());
        return repository.save(exist);
    }

    @Override
    public Product delete(int id) {
        var deleted = get(id);
        repository.delete(deleted);
        return deleted;
    }

    @Override
    public Product create(Product entity) {
        return repository.save(entity);
    }
}
