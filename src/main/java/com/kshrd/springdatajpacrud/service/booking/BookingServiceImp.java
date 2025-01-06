package com.kshrd.springdatajpacrud.service.booking;

import com.kshrd.springdatajpacrud.dto.request.BookingDTO;
import com.kshrd.springdatajpacrud.entity.Booking;
import com.kshrd.springdatajpacrud.entity.BookingDetail;

import com.kshrd.springdatajpacrud.entity.Resource;
import com.kshrd.springdatajpacrud.entity.User;
import com.kshrd.springdatajpacrud.exception.specificException.NotFoundException;
import com.kshrd.springdatajpacrud.exception.specificException.ResourceNotAvailableException;
import com.kshrd.springdatajpacrud.repository.BookingDetailRepository;
import com.kshrd.springdatajpacrud.repository.BookingRepository;
import com.kshrd.springdatajpacrud.repository.ResourceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImp implements BookingService {

    private BookingDetailRepository bookingDetailRepository;
    private BookingRepository bookingRepository;
    private ResourceRepository resourceRepository;

    public BookingServiceImp(BookingDetailRepository bookingDetailRepository, BookingRepository bookingRepository, ResourceRepository resourceRepository) {
        this.bookingDetailRepository = bookingDetailRepository;
        this.bookingRepository = bookingRepository;
        this.resourceRepository = resourceRepository;
    }

    @Override
    public List<BookingDetail> getAllBookings() {
        return bookingDetailRepository.findAll();
    }


    @Override
    public BookingDetail addBooking(BookingDTO bookingRequest) {

        Booking bookingEntity = new Booking();
        User user = new User();


        user.setUserId(bookingRequest.getBookingBy());
        bookingEntity.setDecription(bookingRequest.getBookingDescription());
        bookingEntity.setDepartureTime(bookingRequest.getBookingDate());
        bookingEntity.setUser(user);

        Booking savedBooking = bookingRepository.save(bookingEntity);

        BookingDetail bookingDetail = new BookingDetail();
        bookingDetail.setBooking(savedBooking);


        Resource resource = resourceRepository.findById(bookingRequest.getRecourceId()).orElseThrow(() -> new NotFoundException("Resource not found"));

        if (resource.getIsAvailable().equals(true)) {
            bookingDetail.setResource(resource);
           return bookingDetailRepository.save(bookingDetail);
        }
        else {
            bookingRepository.delete(savedBooking);
            throw new ResourceNotAvailableException("The resource was booked.");
        }

    }
}
