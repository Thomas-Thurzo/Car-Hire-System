package com.thurzo_thomas.car;

public class CarDao {

    private static final Car[] cars;

    static {
        cars = new Car[]{
                new Car(CarModel.BMW, "BD5I SMR", true, false, 4, "Blue"),
                new Car(CarModel.PORSCHE, "LA22 XYZ", true, false, 2, "Black"),
                new Car(CarModel.VOLKSWAGEN, "LY74 ABC", true, false, 6, "White"),
                new Car(CarModel.VOLKSWAGEN, "LY68 CDE", true, true, 4, "Blue"),
        };
    }

    public static Car[] getCars() {
        return cars;
    }
}
