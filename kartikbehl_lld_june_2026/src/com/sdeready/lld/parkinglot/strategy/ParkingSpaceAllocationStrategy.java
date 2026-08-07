package com.sdeready.lld.parkinglot.strategy;

import com.sdeready.lld.parkinglot.dtos.ParkingSpaceAllocationDTO;
import com.sdeready.lld.parkinglot.enums.ParkingSpaceType;
import com.sdeready.lld.parkinglot.model.ParkingFloor;
import com.sdeready.lld.parkinglot.model.ParkingSpace;

import java.util.List;

public interface ParkingSpaceAllocationStrategy {
    ParkingSpaceAllocationDTO allocateParkingSpace(List<ParkingFloor> parkingFloors, ParkingSpaceType parkingSpaceType) throws Exception;
}
