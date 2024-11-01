package com.hackaton.booking_manager.service;

import com.hackaton.booking_manager.entity.Booking;
import com.hackaton.booking_manager.entity.Booking;
import com.hackaton.booking_manager.exceptions.BookingNotFoundException;
import com.hackaton.booking_manager.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Long bookingId){
        return bookingRepository.findById(bookingId)
                .orElseThrow(()-> new BookingNotFoundException(String.format("Booking with id %s not found", bookingId)));
    }

    public Booking saveBooking(Booking booking){
        return bookingRepository.save(booking);
    }

    public Booking updateBooking(Long bookingId, Booking booking){
        Booking existingBooking = getBookingById(bookingId);
        existingBooking.setStartDate(booking.getStartDate());
        existingBooking.setEndDate(booking.getEndDate());
        return bookingRepository.save(existingBooking);
    }

    public String deleteBooking(Long bookingId){
        Booking existingBooking = getBookingById(bookingId);
        bookingRepository.delete(existingBooking);
        return "Booking deleted successfully";
    }
}
