package com.thurzo_thomas.user;

import com.thurzo_thomas.booking.BookingDao;
import com.thurzo_thomas.car.Car;
import com.thurzo_thomas.car.CarDao;

import java.util.Scanner;

public class UserService {

    // Fields
    private Scanner scanner = new Scanner(System.in);

    // Shows all Users on the console
    public void viewAllUsers(){
        for (User user : UserDao.getUsers()){
            System.out.println("First Name: " + user.getFirstName());
            System.out.println("Last Name: " + user.getLastName());
            System.out.println("User ID: " + user.getId());
            System.out.println("-----");
            System.out.println();
        }
    }

    // Show all User Booked Cars
    public void showUserBookedCars(){
        viewAllUsers();
        System.out.println("➡️ Select a User ID");
        String userId = scanner.nextLine();
        Boolean idIsValid = false;
        for (int i = 0; i < UserDao.getUsers().length; i++) {
            if(UserDao.getUsers()[i].getId().equals(userId)){
                idIsValid = true;
            }
        }
        if(!idIsValid) {
            System.out.println("You did not enter a valid user ID! ❌");
            return;
        }

        System.out.println("Bookings for User: " + userId);
        System.out.println("");
        int bookingCounter = 0;
        for (int i = 0; i < BookingDao.getBookings().length; i++) {
            if(BookingDao.getBookings()[i] != null && BookingDao.getBookings()[i].getUserId().equals(userId)){
                System.out.println("Booking ID: " + BookingDao.getBookings()[i].getBookingId());
                System.out.println("Booking Time: " + BookingDao.getBookings()[i].getBookingTime());
                System.out.println("-----");
                bookingCounter ++;
            }
        }
        if(bookingCounter == 0){
            System.out.println("Sorry, no bookings for this ID! 😓");
            System.out.println();
        }
    }
}
