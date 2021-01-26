package com.sahin.springbootelasticsearch.repository;

import com.sahin.springbootelasticsearch.entity.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface UserRepository extends ElasticsearchRepository<User,String> {

    List<User> findByFirstName(String firstName);
    List<User> findByFirstNameContaining(String search);
}
