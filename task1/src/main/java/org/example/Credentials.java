package org.example;

public class Credentials {
    private String username;
    private String password;

    public void setUsername(String username){this.username = username;}
    public void setPassword(String password){this.password = password;}

    public void display(){
        System.out.println("Username: " + username);
    }
}