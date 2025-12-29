package com.parking.service;

import com.parking.dao.ParkingDAO;
import com.parking.model.Car;

public class ParkingService {

    private final ParkingDAO dao = new ParkingDAO();

    // Allocate slot
    public synchronized int park(Car car) throws Exception {
        if (car == null || car.getNumber() == null || car.getNumber().isEmpty()) {
            throw new Exception("Invalid car number");
        }
        return dao.allocate(car.getNumber());
    }

    // Release slot
    public synchronized boolean release(String vehicleNumber) throws Exception {
        return dao.release(vehicleNumber);
    }
}
