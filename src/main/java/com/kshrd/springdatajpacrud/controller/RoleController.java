package com.kshrd.springdatajpacrud.controller;

import com.kshrd.springdatajpacrud.dto.request.RoleRequest;
import com.kshrd.springdatajpacrud.dto.response.ApiResponse;
import com.kshrd.springdatajpacrud.entity.User;
import com.kshrd.springdatajpacrud.service.role.RoleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("api/v1/roles")
public class RoleController {
private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public ResponseEntity<?> addRole(@RequestBody @Valid RoleRequest role) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.builder()
                        .message("Successfully added role")
                        .payload(roleService.createRole(role))
                        .status(HttpStatus.OK)
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRole(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(
                ApiResponse.builder()
                        .message("Successfully deleted user")
                        .payload(roleService.deleteRole(id))
                        .status(HttpStatus.OK)
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }



}
