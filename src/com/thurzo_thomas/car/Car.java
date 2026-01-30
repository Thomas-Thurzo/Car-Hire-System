package com.thurzo_thomas.car;

public class Car {
    // Fields
    private CarModel carModel;
    private String numberPlate;
    private String color;
    private Boolean isAvailable;
    private Boolean isElectric;
    private int seats;


    // Constructor
    public Car(CarModel carModel, String numberPlate, Boolean isAvailable, Boolean isElectric, int seats, String color) {
        this.carModel = carModel;
        this.numberPlate = numberPlate;
        this.isAvailable = isAvailable;
        this.isElectric = isElectric;
        this.seats = seats;
        this.color = color;
    }

    // Getter & Setter
    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
