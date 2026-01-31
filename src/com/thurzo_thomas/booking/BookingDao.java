package com.thurzo_thomas.booking;

import com.thurzo_thomas.car.Car;

public class BookingDao {

    private static Booking[] bookings = new Booking[100];

    public static Booking[] getBookings() {
        return bookings;
    }
}
