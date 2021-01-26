package com.springexample.relationship.manytomany.repository;

import com.springexample.relationship.manytomany.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
