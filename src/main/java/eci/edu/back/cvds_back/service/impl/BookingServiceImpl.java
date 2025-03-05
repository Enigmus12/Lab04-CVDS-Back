package eci.edu.back.cvds_back.service.impl;

import eci.edu.back.cvds_back.config.BookingServiceException;
import eci.edu.back.cvds_back.dto.BookingDTO;
import eci.edu.back.cvds_back.model.Booking;
import eci.edu.back.cvds_back.service.interfaces.BookingRepository;
import eci.edu.back.cvds_back.service.interfaces.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Override
    public Booking getBooking(String id) throws BookingServiceException {
        return bookingRepository.findById(id);
    }

    @Override
    public Booking saveBooking(BookingDTO bookingDTO) {
        Booking booking = new Booking(bookingDTO);
        bookingRepository.save(booking);
        return booking;
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public void deleteBooking(String id) throws BookingServiceException {
        bookingRepository.deleteById(id);
    }


}
