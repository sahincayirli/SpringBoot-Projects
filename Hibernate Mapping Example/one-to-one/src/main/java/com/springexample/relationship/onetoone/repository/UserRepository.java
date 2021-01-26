package com.springexample.relationship.onetoone.repository;

import com.springexample.relationship.onetoone.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
