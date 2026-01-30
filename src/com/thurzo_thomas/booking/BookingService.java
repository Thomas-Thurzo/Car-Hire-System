package com.thurzo_thomas.booking;

import com.thurzo_thomas.car.Car;
import com.thurzo_thomas.car.CarDao;
import com.thurzo_thomas.user.User;
import com.thurzo_thomas.user.UserDao;

import java.util.Scanner;

public class BookingService {

    // Fields
    private Scanner scanner = new Scanner(System.in);

    // View all Bookings
    public void viewAllBookings(){
        int bookingCounter = 0;
        for(Booking booking : BookingDao.getBookings()){
            if(booking != null){
                System.out.println("Booking ID: " + booking.getBookingId());
                System.out.println("Booking Date & Time: ⏲️ " + booking.getBookingTime());
                System.out.println("-----");
                bookingCounter ++;
            }
        }
        if (bookingCounter == 0){
            System.out.println("Sorry, no bookings at the moment! 😓");
            System.out.println();
        }
    }

    // Book a Car
    public void bookCar(){
        // User Input for the number plate
        showAvailableCars();
        System.out.println("➡️ Select a car number plate");
        String numberPlate = scanner.nextLine();
        Boolean plateIsValid = false;
        for (int i = 0; i < CarDao.getCars().length; i++) {
            if(CarDao.getCars()[i].getAvailable() && CarDao.getCars()[i].getNumberPlate().equals(numberPlate)){
                plateIsValid = true;
            }
        }
        if(!plateIsValid) {
            System.out.println("You did not enter a valid license plate number! ❌");
            return;
        }

        // User Input for the User ID
        showUsers();
        System.out.println("➡️ Select a user ID");
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

        // Set Car to not available
        for (int i = 0; i < CarDao.getCars().length; i++) {
            if(CarDao.getCars()[i].getNumberPlate().equals(numberPlate)){
                CarDao.getCars()[i].setAvailable(false);
            }
        }

        // Create a new Booking
        Booking booking = new Booking(userId, numberPlate);
        storeBooking(booking);
        System.out.println("Successfully booked a car 😊");
        System.out.println("Your Booking ID: " + booking.getBookingId());
        System.out.println("Your Booking Date & Time: ⏲️" + booking.getBookingTime());
    }

    // Store Booking in Booking Dao
    private void storeBooking(Booking booking){
        for (int i = 0; i < BookingDao.getBookings().length; i++) {
            if (BookingDao.getBookings()[i] == null){
                BookingDao.getBookings()[i] = booking;
                break;
            }
        }
    }

    // Delete Booking in Booking Dao
    public void deleteBooking(){
        System.out.println("➡️ Enter a Booking ID to delete");
        String bookingId = scanner.nextLine();
        Boolean bookingIdValid = false;
        for (int i = 0; i < BookingDao.getBookings().length; i++) {
            if (BookingDao.getBookings()[i] != null && BookingDao.getBookings()[i].getBookingId().equals(bookingId)){
                BookingDao.getBookings()[i] = null;
                bookingIdValid = true;
                System.out.println("Your booking was successfully removed!");
            }
        }
        if(!bookingIdValid){
            System.out.println("You did not enter a valid booking ID! ❌");
        }

    }

    // Show all available Cars
    private void showAvailableCars(){
        System.out.println("Available Cars 🚗");
        for (Car car : CarDao.getCars()){
            if (car.getAvailable()){
                System.out.println("Model: " + car.getCarModel() + " / Number Plate: " + car.getNumberPlate());
                System.out.println("----------");
            }
        }
    }

    // Show all Users
    private void showUsers(){
        for (User user : UserDao.getUsers()){
            System.out.println("User ID: " + user.getId());
        }
    }
}
