package com.example.springbootfirst.services;

import com.example.springbootfirst.models.Employee;
import com.example.springbootfirst.models.RegisterDetails;
import com.example.springbootfirst.repository.EmployeeRepository;
import com.example.springbootfirst.repository.RegisterDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {


    @Autowired
    RegisterDetailsRepository registerDetailsRepository;

    public List<RegisterDetails> getMethod(){
        return registerDetailsRepository
    }


}
