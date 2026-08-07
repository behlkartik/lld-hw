package com.sdeready.lld.parkinglot.observers;

import com.sdeready.lld.parkinglot.enums.ParkingSpaceType;
import com.sdeready.lld.parkinglot.dtos.ParkingEvent;

public class BikeParkingSpaceObserver extends Observer {
    public BikeParkingSpaceObserver(int availableParkingSpace) {
        super(ParkingSpaceType.BIKE, availableParkingSpace);
    }

    @Override
    public void update(ParkingEvent event) {
        if(event.getParkingSpaceType().equals(ParkingSpaceType.BIKE)){
            this.setAvailableSpaces(event.getAvailableSpaces());
        }
    }
}
