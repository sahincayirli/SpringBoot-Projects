package com.springbootexamples.hateoasexample.repository;

import com.springbootexamples.hateoasexample.models.ActorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<ActorEntity,Long> {
}
