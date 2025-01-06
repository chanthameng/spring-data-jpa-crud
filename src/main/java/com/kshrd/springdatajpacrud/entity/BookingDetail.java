package com.kshrd.springdatajpacrud.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = false)
    @JsonIgnore
    Booking booking;

    @ManyToOne
    @JoinColumn(name = "resource_id", nullable = false)
    Resource resource;

    @Column(name = "is_confirmed", nullable = false)
    Boolean isConfirmed = true;

}
