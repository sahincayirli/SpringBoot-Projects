package com.springexample.hibernatemapping.service;

import com.springexample.hibernatemapping.model.Student;
import com.springexample.hibernatemapping.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public Student getStudent(long id) {
        return repository.findById(id).get();
    }

    public List<Student> students() {
        return repository.findAll();
    }

    public void addStudent(Student student) {
        repository.save(student);
    }

    public void addStudents(List<Student> students) {
        repository.saveAll(students);
    }


}
