package com.springbootexamples.hateoasexample.repository;

import com.springbootexamples.hateoasexample.models.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<AlbumEntity,Long> {
}
