package com.kshrd.springdatajpacrud.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name = "full_name",nullable = false)
    @NotBlank(message = "Please provide an username")
    private String fullName;

    @Column(name = "email",nullable = false)
    @Email(message = "Please provide valid email")
    @NotBlank(message = "Please provide an email")
    private String email;

    @Column(name = "password",nullable = false)
    @NotBlank(message = "Please provide a password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id",nullable = false)
    @NotNull(message = "Role cannot be null")
    private Role role;

    @Column(name = "created_on",nullable = false)
    @NotNull(message = "Timestamp cannot be null")
    private Timestamp createdOn;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Resource> resources;


}
