package com.example.intern.controller;
import java.util.*;
import com.example.intern.models.Student;
import com.example.intern.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService service;


    @GetMapping
    public List<Student> getMethod(){
        return service.getStudents();
    }

    @GetMapping("/{id}")
    public Student getMethod(@PathVariable int id){
        return service.getStudentbyId(id);
    }

    @GetMapping("/name/{name}")
    public List<Student> getMethodByName(@PathVariable String name){
        return service.getStudentbyName(name);
    }

    @PostMapping
    public String postMethod(@RequestBody Student student){
        return service.postStudent(student);
    }

    @PutMapping("/{id}")
    public String putMethod(@PathVariable int id,@RequestBody Student student){
        return service.updateStudent(id,student);
    }

    @DeleteMapping("/{id}")
    public String deleteMethod(@PathVariable int id){
        return service.deleteStudent(id);
    }
}
