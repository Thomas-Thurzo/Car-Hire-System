package com.thurzo_thomas.booking;

import java.util.UUID;

public class BookingService {

    // Book a Car
    public void bookCar(UUID userId, String numberPlate){
        Booking booking = new Booking(userId, numberPlate);
        for (int i = 0; i < BookingDao.getBookings().length; i++) {
            if (BookingDao.getBookings()[i] == null){
                BookingDao.getBookings()[i] = booking;
                break;
            }
        }
    }
}
