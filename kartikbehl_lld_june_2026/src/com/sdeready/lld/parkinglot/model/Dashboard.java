package com.sdeready.lld.parkinglot.model;

import com.sdeready.lld.parkinglot.dtos.ParkingEvent;
import com.sdeready.lld.parkinglot.observers.Observer;

import java.util.List;

public class Dashboard {
    List<Observer> observers;

    public Dashboard(List<Observer> observers) {
        this.observers = observers;
    }

    public void update(ParkingEvent parkingEvent){
        for(Observer observer : observers){
            observer.update(parkingEvent);
        }
    }

    public void show(){
        System.out.println("Dashboard: Available spaces.....");
        for(Observer observer : observers){
            System.out.println(observer.getParkingSpaceType() + ": " + observer.getAvailableSpaces());
        }
    }
}
