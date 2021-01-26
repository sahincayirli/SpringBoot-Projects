package com.sahin.postgresqldatajparest.repository;

import com.sahin.postgresqldatajparest.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
