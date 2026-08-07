package com.sdeready.lld.parkinglot.dtos;

import com.sdeready.lld.parkinglot.model.ParkingFloor;
import com.sdeready.lld.parkinglot.model.ParkingSpace;

public class ParkingSpaceAllocationDTO {
    public ParkingFloor getParkingFloor() {
        return parkingFloor;
    }

    public void setParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloor = parkingFloor;
    }

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(ParkingSpace parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    private ParkingFloor parkingFloor;
    private ParkingSpace parkingSpace;
}
