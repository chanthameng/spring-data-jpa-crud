package com.kshrd.springdatajpacrud.repository;

import com.kshrd.springdatajpacrud.entity.Booking;
import com.kshrd.springdatajpacrud.entity.BookingDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookingRepository extends JpaRepository<BookingDetail, Long> {
}
