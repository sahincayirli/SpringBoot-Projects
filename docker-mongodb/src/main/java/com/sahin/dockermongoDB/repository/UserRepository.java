package com.sahin.dockermongoDB.repository;

import com.sahin.dockermongoDB.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
}
