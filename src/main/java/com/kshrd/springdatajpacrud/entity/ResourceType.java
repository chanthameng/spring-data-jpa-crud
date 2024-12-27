package com.kshrd.springdatajpacrud.entity;

import jakarta.persistence.*;

@Entity
public class ResourceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "type_name")
    private String typeName;
}
