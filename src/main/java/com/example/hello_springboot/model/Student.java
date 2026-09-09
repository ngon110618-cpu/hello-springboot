package com.example.hello_springboot.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String masv; // Đảm bảo tên biến là masv viết thường
    private String hoTen;
    private String email;

    // Getters và Setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getMasv() { return masv; }
    public void setMasv(String masv) { this.masv = masv; }

    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}