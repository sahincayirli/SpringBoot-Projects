package com.springexample.hibernatemapping.repository;

import com.springexample.hibernatemapping.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
