package com.springexample.hibernatemapping.controller;

import com.springexample.hibernatemapping.model.Department;
import com.springexample.hibernatemapping.model.Student;
import com.springexample.hibernatemapping.service.DepartmentService;
import com.springexample.hibernatemapping.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {

    @Autowired private DepartmentService departmentService;
    @Autowired private StudentService studentService;

    @GetMapping("/departments")
    private List<Department> departments() {
        return departmentService.departments();
    }

    @GetMapping("/students")
    private List<Student> students() {
        return studentService.students();
    }

    @GetMapping("/department/{id}")
    private Department department(@PathVariable long id) {
        return departmentService.department(id);
    }

    @GetMapping("/student/{id}")
    private Student student(@PathVariable long id) {
        return studentService.getStudent(id);
    }

    @PostMapping("/addDepartments")
    private void addDepartments(@RequestBody List<Department> departments) {
        departmentService.addMultipleDepartment(departments);
    }

    @PostMapping("/addStudents")
    private void addStudents(@RequestBody List<Student> students) {
        studentService.addStudents(students);
    }

    @PostMapping("addDepartment")
    private void addDepartment(@RequestBody Department department) {
        departmentService.addDepartment(department);
    }

    @PostMapping("/addStudent")
    private void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }







}
