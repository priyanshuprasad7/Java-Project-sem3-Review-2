package com.parking.model;

public class ParkingSlot {
    private int slotId;
    private boolean occupied;

    public ParkingSlot(int slotId) {
        this.slotId = slotId;
        this.occupied = false;
    }

    public int getSlotId() {
        return slotId;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void occupy() {
        occupied = true;
    }

    public void release() {
        occupied = false;
    }
}
