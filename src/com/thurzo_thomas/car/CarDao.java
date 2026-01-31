package com.thurzo_thomas.car;

public class CarDao {

    private static final Car[] cars;

    static {
        cars = new Car[]{
                new Car("LD20 HXA", CarModel.BMW,  "Blue", true, false, 4 ),
                new Car("LX68 BPF", CarModel.VOLKSWAGEN,  "White", true, false, 4 ),
                new Car("LN72 KDJ", CarModel.PORSCHE,  "Black", true, false, 2 ),
                new Car("LO15 VCR", CarModel.AUDI,  "Yellow", true, false, 4 ),
                new Car("LS19 MTE", CarModel.VOLKSWAGEN,  "Red", true, true, 4 ),
        };
    }

    public Car[] getCars() {
        return cars;
    }
}