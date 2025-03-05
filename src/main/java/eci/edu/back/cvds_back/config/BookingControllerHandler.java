package eci.edu.back.cvds_back.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class BookingControllerHandler {
    private Logger logger = LoggerFactory.getLogger(BookingControllerHandler.class);
    @ExceptionHandler(BookingServiceException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleBookingServiceException(BookingServiceException ex) {
        logger.error("Error handled:" + ex.getMessage());
        return "Implementation failed";
    }
}
