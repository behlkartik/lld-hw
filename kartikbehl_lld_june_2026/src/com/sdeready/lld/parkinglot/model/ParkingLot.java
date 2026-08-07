package com.sdeready.lld.parkinglot.model;

import com.sdeready.lld.parkinglot.dtos.ParkingEvent;
import com.sdeready.lld.parkinglot.dtos.ParkingSpaceAllocationDTO;
import com.sdeready.lld.parkinglot.enums.ParkingSpaceType;
import com.sdeready.lld.parkinglot.strategy.FixedPricingStrategy;
import com.sdeready.lld.parkinglot.strategy.ParkingSpaceAllocationStrategy;
import com.sdeready.lld.parkinglot.strategy.PricingStrategy;

import java.time.Duration;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ParkingLot {
    List<ParkingFloor> parkingFloorList;
    ParkingSpaceAllocationStrategy parkingSpaceAllocationStrategy;
    PricingStrategy pricingStrategy;

    Dashboard dashboard;

    public List<ParkingFloor> getParkingFloorList() {
        return parkingFloorList;
    }

    public void setParkingFloorList(List<ParkingFloor> parkingFloorList) {
        this.parkingFloorList = parkingFloorList;
    }

    public PricingStrategy getPricingStrategy() {
        return pricingStrategy;
    }

    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public ParkingSpaceAllocationStrategy getParkingSpaceAllocationStrategy() {
        return parkingSpaceAllocationStrategy;
    }

    public void setParkingSpaceAllocationStrategy(ParkingSpaceAllocationStrategy parkingSpaceAllocationStrategy) {
        this.parkingSpaceAllocationStrategy = parkingSpaceAllocationStrategy;
    }

    public Dashboard getDashboard() {
        return dashboard;
    }

    public void setDashboard(Dashboard dashboard) {
        this.dashboard = dashboard;
    }

    public Ticket park(Vehicle vehicle) throws Exception {
        System.out.println("ParkingLot: Entering parkingLot");
        ParkingSpaceType spaceType = switch (vehicle.getType().toLowerCase()){
            case "car" -> ParkingSpaceType.CAR;
            case "bike" -> ParkingSpaceType.BIKE;
            default -> throw new IllegalArgumentException("Unknown vehicle Type");
        };
        ParkingSpaceAllocationDTO allocatedParkingSpace = parkingSpaceAllocationStrategy.allocateParkingSpace(parkingFloorList, spaceType);
        ParkingSpace parkingSpace = allocatedParkingSpace.getParkingSpace();
        ParkingFloor parkingFloor = allocatedParkingSpace.getParkingFloor();
        parkingSpace.park(vehicle);

        // create ticket
        Ticket ticket = new Ticket();
        ticket.setEntryTime(Instant.now());
        ticket.setParkingSpace(parkingSpace);
        ticket.setParkingFloor(parkingFloor);

        // create parking event and update observers
        ParkingEvent parkingEvent = new ParkingEvent();
        parkingEvent.setParkingSpaceType(spaceType);
        parkingEvent.setAvailableSpaces(getAvailableParkingSpacesByType(spaceType));
        getDashboard().update(parkingEvent);

        return ticket;
    }

    public Double unpark(Ticket ticket) throws Exception {
        System.out.println("ParkingLot: Exiting parkingLot");
        Instant exitTime = Instant.now();
        Duration duration = Duration.between(ticket.getEntryTime(), exitTime);
        Double fare = this.pricingStrategy.getCharge((int)duration.toHours());
        String floorName = ticket.getParkingFloor().getFloorName();
        ParkingSpaceType parkingSpaceType = ticket.getParkingSpace().getParkingSpaceType();
        for(ParkingFloor parkingFloor : parkingFloorList){
            if(parkingFloor.getFloorName().equals(floorName)){
                Queue<ParkingSpace> availableParkingSpaces = parkingFloor.getAvailableSpaces().getOrDefault(parkingSpaceType, new LinkedList<>());
                availableParkingSpaces.offer(ticket.getParkingSpace());
                ticket.getParkingSpace().setOccupied(false);
                break;
            }
        }
        // create parking event and update observers
        ParkingEvent parkingEvent = new ParkingEvent();
        parkingEvent.setParkingSpaceType(parkingSpaceType);
        parkingEvent.setAvailableSpaces(getAvailableParkingSpacesByType(parkingSpaceType));
        getDashboard().update(parkingEvent);
        return fare;
    }

    public int getAvailableParkingSpacesByType(ParkingSpaceType parkingSpaceType){
        int availableParkingSpaces = 0;
        for(ParkingFloor parkingFloor : parkingFloorList){
            Queue<ParkingSpace> parkingSpaces = parkingFloor.getAvailableSpaces().getOrDefault(parkingSpaceType, new LinkedList<>());
            availableParkingSpaces += parkingSpaces.size();
        }
        return availableParkingSpaces;
    }

}
