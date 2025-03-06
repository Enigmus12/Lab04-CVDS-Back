package eci.edu.back.cvds_back.controller;

import eci.edu.back.cvds_back.config.BookingServiceException;
import eci.edu.back.cvds_back.dto.BookingDTO;
import eci.edu.back.cvds_back.model.Booking;
import eci.edu.back.cvds_back.service.interfaces.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking-service")

public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping("/bookings")
    public List<Booking> bookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/bookings/{id}")
    public Booking booking(@PathVariable String id) throws BookingServiceException {
        return bookingService.getBooking(id);
    }

    @PostMapping("/bookings")
    public Booking booking(@RequestBody BookingDTO booking) {
        return bookingService.saveBooking(booking);
    }

    @DeleteMapping("/bookings/{id}")
    public List<Booking> deleteBooking(@PathVariable String id) throws BookingServiceException {
        bookingService.deleteBooking(id);
        return  bookingService.getAllBookings();
    }
}
