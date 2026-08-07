package com.sdeready.lld.parkinglot.dtos;

import com.sdeready.lld.parkinglot.enums.ParkingSpaceType;

public class ParkingEvent {
    int availableSpaces;
    ParkingSpaceType parkingSpaceType;


    public int getAvailableSpaces() {
        return availableSpaces;
    }

    public void setAvailableSpaces(int availableSpaces) {
        this.availableSpaces = availableSpaces;
    }

    public ParkingSpaceType getParkingSpaceType() {
        return parkingSpaceType;
    }

    public void setParkingSpaceType(ParkingSpaceType parkingSpaceType) {
        this.parkingSpaceType = parkingSpaceType;
    }
}
