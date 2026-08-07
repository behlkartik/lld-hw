package com.sdeready.lld.parkinglot.observers;

import com.sdeready.lld.parkinglot.enums.ParkingSpaceType;
import com.sdeready.lld.parkinglot.dtos.ParkingEvent;

public abstract class Observer {
    public void setAvailableSpaces(int availableSpaces) {
        this.availableSpaces = availableSpaces;
    }

    int availableSpaces;
    ParkingSpaceType parkingSpaceType;

    public ParkingSpaceType getParkingSpaceType() {
        return parkingSpaceType;
    }

    abstract public void update(ParkingEvent event);

    public int getAvailableSpaces() {
        return availableSpaces;
    }

    Observer(ParkingSpaceType parkingSpaceType, int availableSpaces) {
        this.parkingSpaceType = parkingSpaceType;
        this.availableSpaces = availableSpaces;
    }
}
