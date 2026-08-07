package com.sdeready.lld.parkinglot.observers;

import com.sdeready.lld.parkinglot.enums.ParkingSpaceType;
import com.sdeready.lld.parkinglot.dtos.ParkingEvent;

public class CarParkingSpaceObserver extends Observer {
    public CarParkingSpaceObserver(int availableParkingSpace) {
        super(ParkingSpaceType.CAR, availableParkingSpace);
    }

    @Override
    public void update(ParkingEvent event) {
        if(event.getParkingSpaceType().equals(ParkingSpaceType.CAR))
            this.setAvailableSpaces(event.getAvailableSpaces());
    }
}
