package com.kshrd.springdatajpacrud.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class ResourceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer typeId;

    @Column(name = "type_name",nullable = false)
    private String typeName;

    @OneToMany(mappedBy = "resourceId")
    @JsonIgnore
    private List<Resource> resources;


}
