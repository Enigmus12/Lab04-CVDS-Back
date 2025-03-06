package eci.edu.back.cvds_back.service.impl;

import eci.edu.back.cvds_back.config.BookingServiceException;
import eci.edu.back.cvds_back.dto.BookingDTO;
import eci.edu.back.cvds_back.model.Booking;
import eci.edu.back.cvds_back.service.interfaces.BookingRepository;
import eci.edu.back.cvds_back.service.interfaces.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Override
    public Booking getBooking(String bookingId) throws BookingServiceException {
        return bookingRepository.findById(bookingId);
    }

    @Override
    public Booking saveBooking(BookingDTO bookingDTO) throws BookingServiceException {
        if (bookingRepository.existsById(bookingDTO.getBookingId())) {
            throw new BookingServiceException("Error: El bookingId '" + bookingDTO.getBookingId() + "' ya existe.");
        }
        Booking booking = new Booking(bookingDTO);
        bookingRepository.save(booking);
        return booking;
    }


    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public void deleteBooking(String bookingId) throws BookingServiceException {
        bookingRepository.deleteById(bookingId);
    }

    @Override
    public Booking updateBooking(String bookingId, boolean status) throws BookingServiceException {
        Booking booking = bookingRepository.findById(bookingId);

        if (status && booking.isDisable()) {
            throw new BookingServiceException("La reserva ya está cancelada.");
        }

        if (!status && !booking.isDisable()) {
            throw new BookingServiceException("La reserva ya está activa.");
        }

        booking.setDisable(status);
        bookingRepository.update(booking);
        return booking;
    }


}