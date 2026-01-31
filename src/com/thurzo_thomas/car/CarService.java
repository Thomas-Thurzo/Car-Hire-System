package com.thurzo_thomas.car;

public class CarService {

    public void setCarNotAvailable(String numberPlate){
        for (int i = 0; i < CarDao.getCars().length; i++) {
            if(CarDao.getCars()[i].getNumberPlate().equals(numberPlate)){
                CarDao.getCars()[i].setAvailable(false);
            }
        }
    }

    public Car getCarByPlateNumber(String numberPlate){
        for(Car car : CarDao.getCars()){
            if(car.getNumberPlate().equals(numberPlate)){
                return car;
            }
        }
        return null;
    }

}
