package com.parking.model;

public class Bike implements Vehicle {
    private String number;

    public Bike(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public String getType() {
        return "BIKE";
    }
}
