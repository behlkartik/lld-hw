package com.sdeready.lld.vendingmachine;

public class Espresso extends Coffee {

    @Override
    public String getName() {
        return "Espresso";
    }

    @Override
    public Double getPrice() {
        return 10.0d;
    }
}
