package com.thurzo_thomas.car;

public class CarService {

    // Shows all available Cars on the console
    public void viewAvailableCars(){
        for (Car car : CarDao.getCars()){
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

    // Shows all available electric Cars on the console
    public void viewAvailableElectricCars(){
        for (Car car : CarDao.getCars()){
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
}
