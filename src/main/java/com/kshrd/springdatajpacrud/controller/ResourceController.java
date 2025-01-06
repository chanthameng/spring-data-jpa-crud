package com.kshrd.springdatajpacrud.controller;

import com.kshrd.springdatajpacrud.dto.request.ResourceRequest;
import com.kshrd.springdatajpacrud.dto.response.ApiResponse;
import com.kshrd.springdatajpacrud.entity.Resource;
import com.kshrd.springdatajpacrud.service.resource.ResourceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/resources")
public class ResourceController {
    private final ResourceService resourceService;

    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @GetMapping("")
    public ResponseEntity<?> getResources() {
        return ResponseEntity.status(HttpStatus.OK).body(
                ApiResponse.builder()
                        .message("Success")
                        .payload(resourceService.getAllResources())
                        .status(HttpStatus.OK)
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }

    @PostMapping("")
    public ResponseEntity<?> createResource(@RequestBody ResourceRequest resourceRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.builder()
                        .message("Success")
                        .payload(resourceService.addRecource(resourceRequest))
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.CREATED)
                        .build()
        );
    }


}
