package com.thurzo_thomas;

import com.thurzo_thomas.app.Gui;
import com.thurzo_thomas.booking.BookingDao;
import com.thurzo_thomas.booking.BookingService;
import com.thurzo_thomas.car.CarDao;
import com.thurzo_thomas.car.CarService;
import com.thurzo_thomas.user.UserFileDataAccessService;
import com.thurzo_thomas.user.UserService;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CarDao carDao = new CarDao();
        CarService carService = new CarService(carDao);
        UserFileDataAccessService userFileDataAccessService = new UserFileDataAccessService();
        UserService userService = new UserService(userFileDataAccessService);
        BookingDao bookingDao = new BookingDao();
        BookingService bookingService = new BookingService(bookingDao);
        new Gui(scanner, carService, userService, bookingService, carDao, bookingDao, userFileDataAccessService).start();
    }

}
