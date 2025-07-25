package com.example.springbootfirst.services;

import com.example.springbootfirst.models.Roles;
import com.example.springbootfirst.models.RegisterDetails;
import com.example.springbootfirst.models.UserDetailsDto;
import com.example.springbootfirst.repository.RolesRepository;
import com.example.springbootfirst.repository.RegisterDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;


import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class RegisterService {

    @Autowired
    RegisterDetailsRepository registerDetailsRepository;

    @Autowired
    RolesRepository rolesRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public String registerNewUser(UserDetailsDto request){
        RegisterDetails user = new RegisterDetails();
        user.setName(request.getName());
        user.setUserName(request.getUserName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        Set<Roles> roles = new HashSet<>();
        for (String roleName : request.getRoleNames()) {
            Roles role = rolesRepository.findByName(roleName)
                    .orElseThrow(() -> new RuntimeException("Role not found: " + roleName));
            roles.add(role);
        }
        user.setRoles(roles);
        registerDetailsRepository.save(user);
        return "Employee Registered Successfully";
    }

    public boolean authenticate(String userName, String rawPassword) {
        Optional<RegisterDetails> userOptional = registerDetailsRepository.findByUserName(userName);
        if (userOptional.isEmpty()) {
            return false;
        }

        RegisterDetails user = userOptional.get();
        return passwordEncoder.matches(rawPassword, user.getPassword());
    }

    public String updateUser(int empId, UserDetailsDto request) {
        RegisterDetails existingUser = registerDetailsRepository.findById(empId)
                .orElse(null);
        if (existingUser == null) {
            return "User with ID " + empId + " not found!";
        }
        existingUser.setName(request.getName());
        existingUser.setUserName(request.getUserName());
        existingUser.setEmail(request.getEmail());
        if (request.getPassword() != null && !request.getPassword().isEmpty()) {
            existingUser.setPassword(passwordEncoder.encode(request.getPassword()));
        }
        Set<Roles> updatedRoles = new HashSet<>();
        for (String roleName : request.getRoleNames()) {
            Roles role = rolesRepository.findByName(roleName)
                    .orElseThrow(() -> new RuntimeException("Role not found: " + roleName));
            updatedRoles.add(role);
        }
        existingUser.setRoles(updatedRoles);
        registerDetailsRepository.save(existingUser);
        return "User updated successfully!";
    }

    public List<RegisterDetails> getUsersByRole(String roleName) {
        return registerDetailsRepository.findByRoleName(roleName);
    }



}
