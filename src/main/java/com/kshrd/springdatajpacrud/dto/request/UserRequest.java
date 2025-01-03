package com.kshrd.springdatajpacrud.dto.request;

import com.kshrd.springdatajpacrud.entity.Role;
import com.kshrd.springdatajpacrud.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    @NotBlank(message = "Please provide a username")
    private String fullName;

    @Email
    @NotBlank(message = "Please provide a password")
    private String email;

    @NotBlank
    @Pattern(
            regexp = "^[A-Za-z0-9]{8,}$",
            message = "Password must be at least 8 characters long and can only contain letters and numbers."
    )
    private String password;

    @NotNull(message = "Role must not be null.")
//    @NotBlank(message = "Please provide role identity number.")
    private Integer role;
}
