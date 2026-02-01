package com.thurzo_thomas.app;

import com.thurzo_thomas.booking.Booking;
import com.thurzo_thomas.booking.BookingDao;
import com.thurzo_thomas.booking.BookingService;
import com.thurzo_thomas.car.Car;
import com.thurzo_thomas.car.CarDao;
import com.thurzo_thomas.car.CarService;
import com.thurzo_thomas.user.User;
import com.thurzo_thomas.user.UserDao;
import com.thurzo_thomas.user.UserService;
import java.util.Scanner;
import java.util.UUID;

public class Gui {

    // Fields
    private final Scanner scanner = new Scanner(System.in);
    private final CarService carService = new CarService();
    private final UserService userService = new UserService();
    private final BookingService bookingService = new BookingService();
    private final CarDao carDao = new CarDao();
    private final BookingDao bookingDao = new BookingDao();
    private final UserDao userDao = new UserDao();

    // User Input processing
    public void start() {

        while (true) {
            printMenu();
            String userInput = scanner.nextLine();
            switch (userInput) {
                case "1":
                    bookCar();
                    break;
                case "2":
                    viewUserBookedCars();
                    break;
                case "3":
                    viewAllBookings();
                    break;
                case "4":
                    viewAvailableCars();
                    break;
                case "5":
                    viewAvailableElectricCars();
                    break;
                case "6":
                    viewAllUsers();
                    break;
                case "7":
                    deleteBooking();
                    break;
                case "8":
                    System.out.println("Good Bye 😊");
                    return;
                default:
                    System.out.println(userInput + " is not a valid input! 😓");
            }
        }
    }

    // Displays the main menu
    private void printMenu() {
        System.out.println("🚗🚗🚗 Car Booking System 🚗🚗🚗");
        System.out.println("1️⃣ - Book Car");
        System.out.println("2️⃣ - View All User Booked Cars");
        System.out.println("3️⃣ - View All Bookings");
        System.out.println("4️⃣ - View Available Cars");
        System.out.println("5️⃣ - View Available Electric Cars");
        System.out.println("6️⃣ - View All Users");
        System.out.println("7️⃣ - Delete Bookings");
        System.out.println("8️⃣ - Exit");
        System.out.print("Choose an option: ");
    }

    // Number 1 - Book a car
    private void bookCar(){
        // User Input and validation for User ID
        viewAllUsers();
        System.out.println("➡️ Select a user ID");
        String inputUserId = scanner.nextLine();
        if(!userService.isValidUUID(inputUserId)){
            System.out.println("Your input is not a valid User ID! ❌");
            return;
        }
        if(userService.getUserById(UUID.fromString(inputUserId)) == null){
            System.out.println("Your User ID is not available! ❌");
            return;
        }

        // User Input and validation for Number Plate
        viewAvailableCars();
        System.out.println("➡️ Select a car number plate");
        String inputNumberPlate = scanner.nextLine();
        if(carService.getCarByPlateNumber(inputNumberPlate) == null){
            System.out.println("Your Number Plate is not available! ❌");
            return;
        }

        // Book the car
        if(bookingService.bookCar(UUID.fromString(inputUserId), inputNumberPlate)){
            carService.setCarNotAvailable(inputNumberPlate);
            System.out.println("Successfully booked a car 😊");
        }else{
            System.out.println("Sorry, something went wrong. No Booking! ❌");
        }
    }

    // Number 2 - View all User Booked Cars
    private void viewUserBookedCars(){
        viewAllUsers();
        System.out.println("➡️ Select a user ID");
        String inputUserId = scanner.nextLine();
        if(!userService.isValidUUID(inputUserId)){
            System.out.println("Your input is not a valid User ID! ❌");
            return;
        }
        if(userService.getUserById(UUID.fromString(inputUserId)) == null){
            System.out.println("Your User ID is not available! ❌");
            return;
        }

        Booking[] bookings = bookingService.getAllBookingsForSpecificUser(UUID.fromString(inputUserId));
        int bookingCounter = 0;
        for(Booking booking : bookings){
            if(booking != null){
                bookingCounter ++;
                System.out.println("Bookings for User: " + inputUserId);
                System.out.println("Booking ID: " + booking.getBookingId());
            }
        }
        if(bookingCounter == 0){
            System.out.println("Sorry, no bookings for this User! 😓");
        }
    }

    // Number 3 - View all Bookings
    private void viewAllBookings(){
        int bookingCounter = 0;
        for(Booking booking : bookingDao.getBookings()){
            if(booking != null){
                System.out.println("Booking ID: " + booking.getBookingId());
                System.out.println("-----");
                bookingCounter ++;
            }
        }
        if (bookingCounter == 0){
            System.out.println("Sorry, no bookings at the moment! 😓");
            System.out.println();
        }
    }

    // Number 4 - View all available Cars
    private void viewAvailableCars(){
        for (Car car : carDao.getCars()){
            System.out.println("Car Model: " + car.getCarModel());
            System.out.println("License Plate: " + car.getNumberPlate());
            if(car.getAvailable()){
                System.out.println("Available: 🆓");
                System.out.println();
            }else{
                System.out.println("Sorry not available! ®️");
                System.out.println();
            }
        }
    }

    // Number 5 - View all available electric Cars
    private void viewAvailableElectricCars(){
        for (Car car : carDao.getCars()){
            if(car.getElectric()){
                System.out.println("Car Model: " + car.getCarModel());
                System.out.println("License Plate: " + car.getNumberPlate());
                if(car.getAvailable()){
                    System.out.println("Available: 🆓");
                    System.out.println();
                }else{
                    System.out.println("Sorry not available! ®️");
                    System.out.println();
                }
            }

        }
    }

    // Number 6 - View all Users
    private void viewAllUsers(){
        for (User user : userDao.getUsers()){
            System.out.println("User ID: " + user.getUserId());
            System.out.println("First Name: " + user.getFirstName());
            System.out.println("Last Name: " + user.getLastName());
            System.out.println("-----");
            System.out.println();
        }
    }

    // Number 7 - Delete Booking
    private void deleteBooking(){
        System.out.println("All available Bookings: ");
        viewAllBookings();
        System.out.println("➡️ Select a Booking ID you want delete");
        String inputBookingId = scanner.nextLine();
        if(!userService.isValidUUID(inputBookingId)){
            System.out.println("Your input is not a valid Booking ID! ❌");
            return;
        }
        if(bookingService.deleteBooking(UUID.fromString(inputBookingId))){
            System.out.println("You deleted successfully the Booking! 😊");
        }else {
            System.out.println("Your Booking ID does not exist. ❌");
        }
    }




}
