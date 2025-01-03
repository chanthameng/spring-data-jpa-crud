package com.kshrd.springdatajpacrud.controller;

import com.kshrd.springdatajpacrud.dto.response.ApiResponse;
import com.kshrd.springdatajpacrud.entity.Booking;
import com.kshrd.springdatajpacrud.service.booking.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/booking")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public ResponseEntity<?> getAllBookings() {
        return ResponseEntity.status(HttpStatus.OK).body(
                ApiResponse.builder()
                        .payload(bookingService.getAllBookings())
                        .message("Successfully get bookings")
                        .status(HttpStatus.OK)
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }
}
