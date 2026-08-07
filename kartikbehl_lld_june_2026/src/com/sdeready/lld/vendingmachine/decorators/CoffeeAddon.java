package com.sdeready.lld.vendingmachine.decorators;

import com.sdeready.lld.vendingmachine.Coffee;

public abstract class CoffeeAddon extends Coffee {
    protected Coffee coffee;

    CoffeeAddon(Coffee coffee){
        super();
        this.coffee = coffee;
    }
}
