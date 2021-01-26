package com.springexample.hibernatemapping.repository;

import com.springexample.hibernatemapping.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
