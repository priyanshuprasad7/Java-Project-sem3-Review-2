package com.parking.model;

public class Car implements Vehicle {
    private String number;

    public Car(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public String getType() {
        return "CAR";
    }
}
