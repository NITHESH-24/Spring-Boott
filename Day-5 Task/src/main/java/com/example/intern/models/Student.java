package com.example.intern.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
@NoArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String studentName;
    private String studentEmail;
    private String studentPhone;

    public Student(){

    }


    public Student(int id, String studentName, String studentEmail, String studentPhone) {
        this.id = id;
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.studentPhone = studentPhone;
    }

    public int getId() {
        return id;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public String getStudentPhone() {
        return studentPhone;
    }
}

