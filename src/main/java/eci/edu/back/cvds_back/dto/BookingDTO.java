package eci.edu.back.cvds_back.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
//@Getter
//@Setter
public class BookingDTO {
    private String bookingId;
    private LocalDate bookingDate;

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }
}
