package com.kshrd.springdatajpacrud.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.awt.*;
import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

@Entity()
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;

    @ManyToOne
    @JoinColumn(name = "booking_by", nullable = false)
    private User user;

    @OneToMany(mappedBy = "booking")
    private Set<BookingDetail> bookingDetail;

    @Column(name = "description")
    private String decription;

    @Column(name = "departure_time", nullable = false)
    private Timestamp departureTime;

}
