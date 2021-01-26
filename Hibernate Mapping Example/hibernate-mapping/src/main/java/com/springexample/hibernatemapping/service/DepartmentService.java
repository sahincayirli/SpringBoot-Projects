package com.springexample.hibernatemapping.service;

import com.springexample.hibernatemapping.model.Department;
import com.springexample.hibernatemapping.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DepartmentService {
    @Autowired
    private DepartmentRepository repository;

    public List<Department> departments() {
        return repository.findAll();
    }

    public Department department(long id) {
        return repository.findById(id).get();
    }

    public void addDepartment(Department department) {
        repository.save(department);
    }

    public void addMultipleDepartment(List<Department> departments) {
        repository.saveAll(departments);
    }

}
