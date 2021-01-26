package com.springexample.relationship.manytomany.repository;

import com.springexample.relationship.manytomany.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
}
