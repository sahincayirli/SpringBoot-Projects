package com.springexamples.hellocoucbase.repository;

import com.springexamples.hellocoucbase.model.User;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CouchbaseRepository<User,Long> {
}
