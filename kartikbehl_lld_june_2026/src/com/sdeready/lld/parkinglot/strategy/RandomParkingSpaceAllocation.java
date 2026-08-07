package com.sdeready.lld.parkinglot.strategy;

import com.sdeready.lld.parkinglot.dtos.ParkingSpaceAllocationDTO;
import com.sdeready.lld.parkinglot.enums.ParkingSpaceType;
import com.sdeready.lld.parkinglot.model.ParkingFloor;
import com.sdeready.lld.parkinglot.model.ParkingSpace;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RandomParkingSpaceAllocation implements ParkingSpaceAllocationStrategy {
    @Override
    public ParkingSpaceAllocationDTO allocateParkingSpace(List<ParkingFloor> parkingFloors, ParkingSpaceType parkingSpaceType) throws Exception {
        ParkingSpace selectedParkingSpace = null;
        ParkingFloor selectedParkingFloor = null;
        for(ParkingFloor parkingFloor : parkingFloors){
            Queue<ParkingSpace> availableParkingSpaces = parkingFloor.getAvailableSpaces().getOrDefault(parkingSpaceType, new LinkedList<>());
            ParkingSpace parkingSpace = availableParkingSpaces.peek();

            if(parkingSpace != null) {
                selectedParkingSpace = parkingSpace;
                selectedParkingFloor = parkingFloor;
                break;
            }
        }

        if(selectedParkingSpace == null || selectedParkingFloor == null){
            throw new Exception("No "+parkingSpaceType+" space available on any parking floor");
        }

        Queue<ParkingSpace> availableParkingSpaces = selectedParkingFloor.getAvailableSpaces().getOrDefault(parkingSpaceType, new LinkedList<>());
        availableParkingSpaces.poll();
        ParkingSpaceAllocationDTO parkingSpaceAllocationDTO = new ParkingSpaceAllocationDTO();
        parkingSpaceAllocationDTO.setParkingFloor(selectedParkingFloor);
        parkingSpaceAllocationDTO.setParkingSpace(selectedParkingSpace);
        return parkingSpaceAllocationDTO;
    }
}
