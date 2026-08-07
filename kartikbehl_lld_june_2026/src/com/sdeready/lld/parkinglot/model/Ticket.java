package com.sdeready.lld.parkinglot.model;

import java.time.Instant;

public class Ticket {
    Instant entryTime;
    ParkingSpace parkingSpace;

    ParkingFloor parkingFloor;

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(ParkingSpace parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    public Instant getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Instant entryTime) {
        this.entryTime = entryTime;
    }
    public ParkingFloor getParkingFloor() {
        return parkingFloor;
    }

    public void setParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloor = parkingFloor;
    }

    @Override
    public String toString() {
        return "Got ticket Floor: "+ getParkingFloor().getFloorName() +", Type: "+ getParkingSpace().getParkingSpaceType()+", parking space number: " + getParkingSpace().getId() +", entryTime: "+ getEntryTime();
    }
}
