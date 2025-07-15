package com.example.springbootfirst.services;

import com.example.springbootfirst.models.RegisterDetails;
import com.example.springbootfirst.models.Roles;
import com.example.springbootfirst.repository.RegisterDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthService {

    @Autowired
    private RegisterDetailsRepository registerDetailsRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String addUserDetails(RegisterDetails register) {
        // Check if email already exists
        if (registerDetailsRepository.findByEmail(register.getEmail()) != null) {
            return "Email already registered";
        }

        RegisterDetails registerDetails = new RegisterDetails();
        registerDetails.setEmail(register.getEmail());
        registerDetails.setPassword(passwordEncoder.encode(register.getPassword()));
        registerDetails.setUserName(register.getUserName());
        registerDetails.setGender(register.getGender());
        registerDetails.setDob(register.getDob());

        // Set roles - assuming register.getRole() returns Set<Roles>
        // If you need to validate or transform roles, do it here
        registerDetails.setRole(register.getRole());

        registerDetailsRepository.save(registerDetails);
        return "User Details saved successfully";
    }

    public String authentication(RegisterDetails userDetails) {
        RegisterDetails user = registerDetailsRepository.findByEmail(userDetails.getEmail());

        // Check if user exists
        if (user == null) {
            return "Enter the correct email";
        }

        // Check password
        if (passwordEncoder.matches(userDetails.getPassword(), user.getPassword())) {
            return "User login successful";
        } else {
            return "Enter the correct password";
        }
    }
}