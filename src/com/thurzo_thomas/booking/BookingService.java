package com.thurzo_thomas.booking;

import java.util.UUID;

public class BookingService {

    private BookingDao bookingDao = new BookingDao();

    public boolean bookCar(UUID userId, String numberPlate){
        Booking booking = new Booking(userId, numberPlate);
        for (int i = 0; i < bookingDao.getBookings().length; i++) {
            if (bookingDao.getBookings()[i] == null){
                bookingDao.getBookings()[i] = booking;
                return true;
            }
        }
        return false;
    }

    public Booking[] getAllBookingsForSpecificUser(UUID userId){
        Booking[] bookings = new Booking[bookingDao.getBookings().length];
        for (int i = 0; i < bookingDao.getBookings().length; i++) {
            if(bookingDao.getBookings()[i] != null && bookingDao.getBookings()[i].getUserId().equals(userId)){
                bookings[i] = bookingDao.getBookings()[i];
            }
        }
        return bookings;
    }


}
