package com.sdeready.designpatterns.creational.vendingmachine;

public class Latte extends Coffee {


    @Override
    public String getName() {
        return "Latte";
    }

    @Override
    public Double getPrice() {
        return 15.0d;
    }
}
