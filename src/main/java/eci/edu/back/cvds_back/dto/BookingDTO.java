package eci.edu.back.cvds_back.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

//@Getter
//@Setter
public class BookingDTO {
    private String bookingId;
    private LocalDate bookingDate;
    private LocalTime bookingTime;
    private String bookingClassRoom;

    public String getBookingId() {return bookingId;}
    public void setBookingId(String bookingId) {this.bookingId = bookingId;}

    public LocalDate getBookingDate() {return bookingDate;}
    public void setBookingDate(LocalDate bookingDate) {this.bookingDate = bookingDate;}

    public LocalTime getBookingTime() {return bookingTime;}
    public void setBookingTime(LocalTime bookingTime) {this.bookingTime = bookingTime;}

    public String getBookingClassRoom() {return bookingClassRoom;}
    public void setBookingClassRoom(String bookingClassRoom) {this.bookingClassRoom = bookingClassRoom;}

}
