package com.kshrd.springdatajpacrud.repository;

import com.kshrd.springdatajpacrud.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
