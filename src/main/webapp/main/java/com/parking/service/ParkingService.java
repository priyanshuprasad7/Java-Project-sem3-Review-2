package com.parking.service;

import com.parking.dao.ParkingDAO;
import com.parking.exception.SlotNotAvailableException;
import com.parking.model.Vehicle;

public class ParkingService {

    SlotAllocator allocator = new SlotAllocator();
    ParkingDAO dao = new ParkingDAO();

    public int park(Vehicle v) throws Exception {
        int slot = allocator.allocate();
        dao.saveAllocation(v.getNumber(), slot);
        return slot;
    }
}
