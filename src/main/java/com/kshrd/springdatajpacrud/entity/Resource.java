package com.kshrd.springdatajpacrud.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;
@Entity
@Getter
@Setter
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer resourceId;
    private String resourceName;

    @Column(unique=true)
    private String labelNo;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private ResourceType resourceType;

    @ManyToOne
    @JoinColumn(name = "created_by")
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "resource")
    @JsonIgnore
    private Set<BookingDetail> bookings;

    @Column(name = "imported_on")
    private Timestamp importedOn;

    private Boolean isAvailable;




}
