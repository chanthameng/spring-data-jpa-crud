package com.kshrd.springdatajpacrud.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

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

    @Column(name = "description",nullable=false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "type_id",nullable=false)
    private ResourceType resourceType;

    @ManyToOne
    @JoinColumn(name = "created_by",nullable=false)
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "resource")
    @JsonIgnore
    private Set<BookingDetail> bookings;

    @Column(name = "imported_on",nullable=false)
    private Timestamp importedOn;

    @Column(name = "is_available")
    private Boolean isAvailable=true;


}
