package com.kshrd.springdatajpacrud.service.booking;

import com.kshrd.springdatajpacrud.dto.request.BookingDTO;
import com.kshrd.springdatajpacrud.entity.Booking;
import com.kshrd.springdatajpacrud.entity.BookingDetail;

import java.util.List;

public interface BookingService {
    public List<BookingDetail> getAllBookings();
    public BookingDetail addBooking(BookingDTO booking);
}
