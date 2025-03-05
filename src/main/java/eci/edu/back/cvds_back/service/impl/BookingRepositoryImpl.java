package eci.edu.back.cvds_back.service.impl;

import eci.edu.back.cvds_back.config.BookingServiceException;
import eci.edu.back.cvds_back.model.Booking;
import eci.edu.back.cvds_back.service.interfaces.BookingMongoRepository;
import eci.edu.back.cvds_back.service.interfaces.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingRepositoryImpl implements BookingRepository {
    @Autowired
    private BookingMongoRepository bookingMongoRepository;
    @Override
    public void save(Booking booking) {
        bookingMongoRepository.save(booking);
    }

    @Override
    public List<Booking> findAll() {
        return bookingMongoRepository.findAll();
    }

    @Override
    public Booking findById(String id) throws BookingServiceException{
        Optional<Booking> booking = bookingMongoRepository.findById(id);
        if(booking.isEmpty()) throw new BookingServiceException("Booking Not found");
        return booking.get();
    }

    @Override
    public void deleteById(String id) throws BookingServiceException {
        bookingMongoRepository.deleteById(id);
    }
}
