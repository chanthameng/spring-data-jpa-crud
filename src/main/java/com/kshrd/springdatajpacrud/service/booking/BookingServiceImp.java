package com.kshrd.springdatajpacrud.service.booking;

import com.kshrd.springdatajpacrud.entity.Booking;
import com.kshrd.springdatajpacrud.entity.BookingDetail;

import com.kshrd.springdatajpacrud.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImp implements BookingService {

    private BookingRepository bookingRepository;

    public BookingServiceImp(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public List<BookingDetail> getAllBookings() {
        return bookingRepository.findAll();
    }
}
