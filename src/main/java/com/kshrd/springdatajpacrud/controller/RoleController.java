package com.kshrd.springdatajpacrud.controller;

import com.kshrd.springdatajpacrud.dto.response.ApiResponse;
import com.kshrd.springdatajpacrud.entity.User;
import com.kshrd.springdatajpacrud.service.role.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/v1/roles")
public class RoleController {
private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public ResponseEntity<?> addRole(@RequestBody String role) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.builder()
                        .message("Successfully added role")
                        .payload(roleService.createRole(role))
                        .status(HttpStatus.OK)
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }
    @DeleteMapping
    public ResponseEntity<?> deleteUser(@RequestBody Integer id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                ApiResponse.builder()
                        .message("Successfully deleted user")
                        .payload(roleService.deleteRole(id))
                        .status(HttpStatus.NO_CONTENT)
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }



}
