package com.thurzo_thomas.car;

import java.util.Objects;

public class Car {
    // Fields
    private String numberPlate;
    private CarModel carModel;
    private String color;
    private Boolean isAvailable;
    private Boolean isElectric;
    private int seats;

    // Constructor
    public Car(String numberPlate, CarModel carModel, String color, Boolean isAvailable, Boolean isElectric, int seats) {
        this.numberPlate = numberPlate;
        this.carModel = carModel;
        this.color = color;
        this.isAvailable = isAvailable;
        this.isElectric = isElectric;
        this.seats = seats;
    }

    // Getter & Setter
    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public Boolean getElectric() {
        return isElectric;
    }

    public void setElectric(Boolean electric) {
        isElectric = electric;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return seats == car.seats && carModel == car.carModel && Objects.equals(numberPlate, car.numberPlate) && Objects.equals(color, car.color) && Objects.equals(isAvailable, car.isAvailable) && Objects.equals(isElectric, car.isElectric);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carModel, numberPlate, color, isAvailable, isElectric, seats);
    }

    @Override
    public String toString() {
        return "Car{" +
                "carModel=" + carModel +
                ", numberPlate='" + numberPlate + '\'' +
                ", isAvailable=" + isAvailable +
                ", isElectric=" + isElectric +
                ", seats=" + seats +
                ", color='" + color + '\'' +
                '}';
    }
}
