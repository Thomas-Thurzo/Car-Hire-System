package com.thurzo_thomas.car;

public class CarService {

    CarDao carDao;

    public CarService(CarDao carDao) {
        this.carDao = carDao;
    }

    public void setCarNotAvailable(String numberPlate){
        for (int i = 0; i < carDao.getCars().length; i++) {
            if(carDao.getCars()[i].getNumberPlate().equals(numberPlate)){
                carDao.getCars()[i].setAvailable(false);
            }
        }
    }

    public Car getCarByPlateNumber(String numberPlate){
        for(Car car : carDao.getCars()){
            if(car.getNumberPlate().equals(numberPlate)){
                return car;
            }
        }
        return null;
    }

}
