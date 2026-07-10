package com.sdeready.designpatterns.creational.vendingmachine.decorators;

import com.sdeready.designpatterns.creational.vendingmachine.Coffee;

public abstract class CoffeeAddon extends Coffee {
    protected Coffee coffee;

    CoffeeAddon(Coffee coffee){
        super();
        this.coffee = coffee;
    }
}
