package com.kshrd.springdatajpacrud.entity;

import jakarta.persistence.*;

import java.util.UUID;
@Entity
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID resourceId;
    private String resourceName;

    @Column(unique=true)
    private String labelNo;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private ResourceType resourceType;
    private String description;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User user;
}
