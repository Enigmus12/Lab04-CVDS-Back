package eci.edu.back.cvds_back.config;

public class BookingServiceException extends Exception {
    private final int errorCode; // Código de error opcional

    public BookingServiceException(String message) {
        super(message);
        this.errorCode = 0; // Código por defecto
    }

    public BookingServiceException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public BookingServiceException(String message, Throwable cause) {
        super(message, cause);
        this.errorCode = 0;
    }

    public BookingServiceException(String message, int errorCode, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
