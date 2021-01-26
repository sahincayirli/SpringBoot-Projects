package com.springexample.onetomany.relationshipexample.repository;

import com.springexample.onetomany.relationshipexample.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
