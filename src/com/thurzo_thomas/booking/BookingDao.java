package com.thurzo_thomas.booking;

import com.thurzo_thomas.car.Car;

public class BookingDao {

    private static Booking[] bookings = new Booking[100];

    public void updateBooking(Booking[] bookings){
        // TODO
        // Aktualisiert das bookingData File.
    }

    public static Booking[] getBookings() {
        // TODO
        // Liest aus dem File und gibt ein Booking Array zurück
        return bookings;
    }
}
