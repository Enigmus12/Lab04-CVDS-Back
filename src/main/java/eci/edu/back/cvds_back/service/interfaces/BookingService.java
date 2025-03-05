package eci.edu.back.cvds_back.service.interfaces;

import eci.edu.back.cvds_back.config.BookingServiceException;
import eci.edu.back.cvds_back.dto.BookingDTO;
import eci.edu.back.cvds_back.model.Booking;

import java.util.List;

public interface BookingService {
    Booking getBooking(String id) throws BookingServiceException;
    Booking saveBooking(BookingDTO booking);
    List<Booking> getAllBookings();
    void deleteBooking(String id) throws BookingServiceException;
}
