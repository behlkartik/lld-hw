package com.sdeready.lld.parkinglot.model;

import com.sdeready.lld.parkinglot.enums.ParkingSpaceType;

public class ParkingSpace {

    int id;
    ParkingSpaceType parkingSpaceType;
    boolean isOccupied;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ParkingSpaceType getParkingSpaceType() {
        return parkingSpaceType;
    }

    public void setParkingSpaceType(ParkingSpaceType parkingSpaceType) {
        this.parkingSpaceType = parkingSpaceType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public ParkingSpace(int id, ParkingSpaceType parkingSpaceType) {
        this.id = id;
        this.parkingSpaceType = parkingSpaceType;
    }

    public void park(Vehicle vehicle) {
        if(!parkingSpaceType.toString().toLowerCase().equals(vehicle.getType())){
            throw new IllegalArgumentException("Vehicle type is not equal to Parking Space type");
        }
        this.setOccupied(true);
    }


    public void unpark() {
        this.setOccupied(false);
    }
}

