package com.sdeready.lld.parkinglot;

import com.sdeready.lld.parkinglot.enums.ParkingSpaceType;
import com.sdeready.lld.parkinglot.model.*;
import com.sdeready.lld.parkinglot.observers.BikeParkingSpaceObserver;
import com.sdeready.lld.parkinglot.observers.CarParkingSpaceObserver;
import com.sdeready.lld.parkinglot.strategy.IncrementalPricingStrategy;
import com.sdeready.lld.parkinglot.strategy.RandomParkingSpaceAllocation;

import java.util.ArrayList;
import java.util.List;

public class Driver {
    public static void main(String[] args) throws Exception {
        // main trigger method
        List<ParkingFloor> parkingFloors = new ArrayList<>();


        ParkingFloor parkingFloor1 = new ParkingFloor();
        parkingFloor1.setFloorName("f1");
        for(int i = 0; i < 10; i++){
            parkingFloor1.addParkingSpace(ParkingSpaceType.BIKE, new ParkingSpace(i+1, ParkingSpaceType.BIKE));
            parkingFloor1.addParkingSpace(ParkingSpaceType.CAR, new ParkingSpace(i+1, ParkingSpaceType.CAR));
        }
        parkingFloors.add(parkingFloor1);

        parkingFloor1 = new ParkingFloor();
        parkingFloor1.setFloorName("f2");
        for(int i = 0; i < 10; i++){
            parkingFloor1.addParkingSpace(ParkingSpaceType.BIKE, new ParkingSpace(i+1, ParkingSpaceType.BIKE));
            parkingFloor1.addParkingSpace(ParkingSpaceType.CAR, new ParkingSpace(i+1, ParkingSpaceType.CAR));
        }
        parkingFloors.add(parkingFloor1);

        Dashboard dashboard = new Dashboard(List.of(new CarParkingSpaceObserver(20), new BikeParkingSpaceObserver(20)));

        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setPricingStrategy(new IncrementalPricingStrategy());
        parkingLot.setParkingSpaceAllocationStrategy(new RandomParkingSpaceAllocation());
        parkingLot.setParkingFloorList(parkingFloors);
        parkingLot.setDashboard(dashboard);
        parkingLot.getDashboard().show();

        Ticket ticket = parkingLot.park(new Car());
        System.out.println(ticket);
        parkingLot.getDashboard().show();

        Ticket ticket1 = parkingLot.park(new Car());
        System.out.println(ticket1);
        parkingLot.getDashboard().show();
        Double fare = parkingLot.unpark(ticket1);
        System.out.println("Final fare: "+ fare);
        parkingLot.getDashboard().show();

        Ticket ticket2 = parkingLot.park(new Car());
        System.out.println(ticket2);
        parkingLot.getDashboard().show();
        fare = parkingLot.unpark(ticket2);
        System.out.println("Final fare: "+ fare);
        parkingLot.getDashboard().show();


        fare = parkingLot.unpark(ticket);
        System.out.println("Final fare: "+ fare);
        parkingLot.getDashboard().show();

    }
}
