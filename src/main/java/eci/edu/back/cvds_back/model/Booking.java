package eci.edu.back.cvds_back.model;

import eci.edu.back.cvds_back.dto.BookingDTO;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;

@Document(collection = "bookings")
public class Booking {
    @MongoId
    private String id;
    private String bookingId;
    private String userId;
    private LocalDate bookingDate;

    @PersistenceCreator
    public Booking(String id, String bookingId, String userId, LocalDate bookingDate) {
        this.id = id;
        this.bookingId = bookingId;
        this.userId = userId;
        this.bookingDate = bookingDate;

    }

    public Booking(BookingDTO bookingDTO) {
        this.bookingDate = bookingDTO.getBookingDate();
        this.userId = bookingDTO.getUserId();
        this.bookingId = bookingDTO.getBookingId();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }
}
