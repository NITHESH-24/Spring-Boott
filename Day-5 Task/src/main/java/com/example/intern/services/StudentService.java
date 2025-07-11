package com.example.intern.services;

import com.example.intern.models.Student;
import com.example.intern.repository.Studentrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    Studentrepo repo;

    public List<Student> getStudents(){
        return repo.findAll();
    }

    public Student getStudentbyId(int id){
        return repo.findById(id);
    }

    public List<Student> getStudentbyName(String name){
        return repo.findByStudentName(name);
    }

    public String postStudent(Student student){
          repo.save(student);
          return "Student added successfully";
    }

    public String updateStudent(int id,Student student){
        List<Student> students = repo.findAll();
        for(Student s : students){
            if(s.getId() == id){
                repo.deleteById(id);
                repo.save(student);
                return "Student updated successfully";
            }
        }
        return "Student not found";
    }

    public String deleteStudent(int id){
        repo.deleteById(id);
        return "Student deleted successfully";
    }
}
