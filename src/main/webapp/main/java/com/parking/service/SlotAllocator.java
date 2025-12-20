package com.parking.service;

import com.parking.exception.SlotNotAvailableException;
import com.parking.model.ParkingSlot;

import java.util.ArrayList;
import java.util.List;

public class SlotAllocator {

    private static List<ParkingSlot> slots = new ArrayList<>();

    static {
        for (int i = 1; i <= 10; i++)
            slots.add(new ParkingSlot(i));
    }

    public synchronized int allocate() throws SlotNotAvailableException {
        for (ParkingSlot s : slots) {
            if (!s.isOccupied()) {
                s.occupy();
                return s.getSlotId();
            }
        }
        throw new SlotNotAvailableException("No Slot Available");
    }
}
