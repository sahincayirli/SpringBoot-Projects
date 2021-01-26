package com.sahin.crud.example.service;

import java.util.Collection;

public interface EntityServiceTemplate<T> {
    T get(int id);
    Collection<T> getAll();
    T update(T entity);
    T delete(int id);
    T create(T entity);
}
