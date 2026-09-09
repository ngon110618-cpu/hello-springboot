package com.example.hello_springboot.controller;

import com.example.hello_springboot.model.Student;
import com.example.hello_springboot.repository.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
public class StudentViewController {

    private final StudentRepository studentRepository;

    public StudentViewController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Hiển thị danh sách sinh viên
    @GetMapping("/students-view")
    public String showStudentList(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        if (!model.containsAttribute("editingStudent")) {
            model.addAttribute("editingStudent", new Student());
        }
        return "students";
    }

    // Thêm mới hoặc Cập nhật sinh viên
    @PostMapping("/students-view/save")
    public String saveStudent(@ModelAttribute("editingStudent") Student student) {
        studentRepository.save(student);
        return "redirect:/students-view";
    }

    // Load dữ liệu sinh viên lên Form để Sửa
    @GetMapping("/students-view/edit/{id}")
    public String editStudent(@PathVariable("id") UUID id, Model model) {
        Student student = studentRepository.findById(id).orElse(null);
        model.addAttribute("students", studentRepository.findAll());
        model.addAttribute("editingStudent", student);
        return "students";
    }

    // Xóa sinh viên theo ID
    @GetMapping("/students-view/delete/{id}")
    public String deleteStudent(@PathVariable("id") UUID id) {
        studentRepository.deleteById(id);
        return "redirect:/students-view";
    }
}