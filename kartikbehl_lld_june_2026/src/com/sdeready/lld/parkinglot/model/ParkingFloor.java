package com.sdeready.lld.parkinglot.model;

import com.sdeready.lld.parkinglot.enums.ParkingSpaceType;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ParkingFloor {
    private String floorName;
    private Map<ParkingSpaceType, Queue<ParkingSpace>> availableSpaces = new HashMap<>();

    public String getFloorName() {
        return floorName;
    }
    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public void addParkingSpace(ParkingSpaceType type, ParkingSpace parkingSpace) {
        Queue<ParkingSpace> availableParkingSpaces = availableSpaces.getOrDefault(type, new LinkedList<>());
        availableParkingSpaces.offer(parkingSpace);
        availableSpaces.put(type, availableParkingSpaces);
    }
    public void removeParkingSpace(ParkingSpaceType type) {
        Queue<ParkingSpace> availableParkingSpaces = availableSpaces.getOrDefault(type, new LinkedList<>());
        availableParkingSpaces.poll();
    }

    public Map<ParkingSpaceType, Queue<ParkingSpace>> getAvailableSpaces() {
        return availableSpaces;
    }
}
