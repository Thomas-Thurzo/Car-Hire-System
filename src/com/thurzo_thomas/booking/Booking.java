package com.thurzo_thomas.booking;

import java.time.LocalDateTime;
import java.util.UUID;

public class Booking {
    // Fields
    private final String userId;
    private final String numberPlate;
    private final String bookingId;
    private final LocalDateTime bookingTime;


    // Constructor
    public Booking(String userId, String numberPlate) {
        this.userId = userId;
        this.numberPlate = numberPlate;
        this.bookingTime = LocalDateTime.now();
        this.bookingId = UUID.randomUUID().toString();
    }

    // Getter
    public String getUserId() {
        return userId;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public String getBookingId() {
        return bookingId;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "userId='" + userId + '\'' +
                ", numberPlate='" + numberPlate + '\'' +
                ", bookingId='" + bookingId + '\'' +
                ", bookingTime=" + bookingTime +
                '}';
    }
}
