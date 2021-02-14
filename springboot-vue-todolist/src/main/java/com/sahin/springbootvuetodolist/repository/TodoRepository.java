package com.sahin.springbootvuetodolist.repository;

import com.sahin.springbootvuetodolist.model.Todo;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TodoRepository extends CouchbaseRepository<Todo,String> {
}
