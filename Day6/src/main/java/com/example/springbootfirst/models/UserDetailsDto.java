package com.example.springbootfirst.models;


import java.util.Set;

public class UserDetailsDto {
    private int empId;
    private String name;
    private String email;

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRoleNames(Set<String> roleNames) {
        this.roleNames = roleNames;
    }

    public int getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public Set<String> getRoleNames() {
        return roleNames;
    }

    public UserDetailsDto(int empId, String name, String email, String password, String username, Set<String> roleNames) {
        this.empId = empId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.username = username;
        this.roleNames = roleNames;
    }

    private String password;
    private String username;
    private Set<String> roleNames;
}