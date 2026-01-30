package com.thurzo_thomas.app;

import com.thurzo_thomas.booking.BookingService;
import com.thurzo_thomas.car.CarService;
import com.thurzo_thomas.user.UserService;

import java.util.Scanner;

public class Gui {

    // Fields
    private Scanner scanner = new Scanner(System.in);
    private CarService carService = new CarService();
    private UserService userService = new UserService();
    private BookingService bookingService = new BookingService();

    // User Input processing
    public void start() {

        while (true) {
            printMenu();
            String userInput = scanner.nextLine();
            switch (userInput) {
                case "1":
                    bookingService.bookCar();
                    break;
                case "2":
                    userService.showUserBookedCars();
                    break;
                case "3":
                    bookingService.viewAllBookings();
                    break;
                case "4":
                    carService.viewAvailableCars();
                    break;
                case "5":
                    carService.viewAvailableElectricCars();
                    break;
                case "6":
                    userService.viewAllUsers();
                    break;
                case "7":
                    bookingService.deleteBooking();
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
}
