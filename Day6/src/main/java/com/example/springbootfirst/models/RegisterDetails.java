package com.example.springbootfirst.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@Table(name="user_details")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RegisterDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int empId;
  @Column(name = "user_name",nullable = false,unique = true)
  private String userName;
  @Column(nullable = false,unique = true)
  private String email;
  @Column(nullable = false)
  private String password;

  private String gender;
  @Column(name="Date_of_Birth")
  private Date dob;

  @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
  @JoinTable(name = "user_roles",joinColumns =
    @JoinColumn(name = "user_id",referencedColumnName ="empId"),
          inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "roleId")
  )
  private Set<Roles> role;
}
