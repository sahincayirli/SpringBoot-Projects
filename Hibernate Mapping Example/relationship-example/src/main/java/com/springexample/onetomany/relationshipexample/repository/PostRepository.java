package com.springexample.onetomany.relationshipexample.repository;

import com.springexample.onetomany.relationshipexample.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
