package com.sahin.crud.example.controller;

import com.sahin.crud.example.entity.Product;
import com.sahin.crud.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    //POST
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return service.create(product);
    }

    //GET
    @GetMapping("/products")
    public Collection<Product> findAllProducts(){
        return service.getAll();
    }

    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable int id){
        return service.get(id);
    }

    //PUT / UPDATE
    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product){
        return service.update(product);
    }

    //DELETE
    @DeleteMapping("delete/{id}")
    public Product deleteProduct(@PathVariable int id){
        return service.delete(id);
    }


}
