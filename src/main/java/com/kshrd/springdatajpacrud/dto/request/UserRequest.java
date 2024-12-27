package com.kshrd.springdatajpacrud.dto.request;

import com.kshrd.springdatajpacrud.entity.Role;
import com.kshrd.springdatajpacrud.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private String fullName;
    private String email;
    private String password;
    private Integer role;
}
