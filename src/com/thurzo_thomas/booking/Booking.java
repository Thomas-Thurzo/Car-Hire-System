package com.thurzo_thomas.booking;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Booking {
    // Fields
    private final UUID bookingId;
    private final UUID userId;
    private final String numberPlate;

    // Constructor
    public Booking(UUID userId, String numberPlate) {
        this.bookingId = UUID.randomUUID();
        this.userId = userId;
        this.numberPlate = numberPlate;
    }

    // Getter
    public UUID getBookingId() {
        return bookingId;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(bookingId, booking.bookingId) && Objects.equals(userId, booking.userId) && Objects.equals(numberPlate, booking.numberPlate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, userId, numberPlate);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", userId=" + userId +
                ", numberPlate='" + numberPlate + '\'' +
                '}';
    }
}
