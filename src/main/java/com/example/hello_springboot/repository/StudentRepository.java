package com.example.hello_springboot.repository;

import com.example.hello_springboot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {
}