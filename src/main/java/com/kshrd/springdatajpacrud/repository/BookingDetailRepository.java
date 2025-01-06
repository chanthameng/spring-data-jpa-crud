package com.kshrd.springdatajpacrud.repository;

import com.kshrd.springdatajpacrud.entity.BookingDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingDetailRepository extends JpaRepository<BookingDetail, Integer> {
}
