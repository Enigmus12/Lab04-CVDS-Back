package eci.edu.back.cvds_back.service.interfaces;

import eci.edu.back.cvds_back.config.BookingServiceException;
import eci.edu.back.cvds_back.model.Booking;

import java.util.List;

public interface BookingRepository {
    void save(Booking booking);
    List<Booking> findAll();
    Booking findById(String id) throws BookingServiceException;
    void deleteById(String id) throws BookingServiceException;
}
