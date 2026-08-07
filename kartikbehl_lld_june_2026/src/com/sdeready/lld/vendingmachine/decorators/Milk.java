package com.sdeready.lld.vendingmachine.decorators;

import com.sdeready.lld.vendingmachine.Coffee;

public class Milk extends CoffeeAddon{
    public Milk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getName() {
        return this.coffee.getName() + "+" + "Milk";
    }

    @Override
    public Double getPrice() {
        return this.coffee.getPrice() + 2.0d;
    }
}
