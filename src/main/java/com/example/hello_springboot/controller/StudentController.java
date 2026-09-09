package com.example.hello_springboot.controller;

import com.example.hello_springboot.model.Student;
import com.example.hello_springboot.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping(value = "/students", produces = "application/json;charset=UTF-8")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}