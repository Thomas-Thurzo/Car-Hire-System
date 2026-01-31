package com.thurzo_thomas.booking;

public class BookingDao {

    private static Booking[] bookings = new Booking[100];

    public Booking[] getBookings() {
        return bookings;
    }
}
