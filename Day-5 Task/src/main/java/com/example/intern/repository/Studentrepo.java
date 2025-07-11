package com.example.intern.repository;

import com.example.intern.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Studentrepo extends JpaRepository<Student,Integer> {
    List<Student> findByStudentName(String name);
    Student findById(int id);
}
