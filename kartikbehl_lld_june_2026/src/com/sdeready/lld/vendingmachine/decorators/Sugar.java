package com.sdeready.lld.vendingmachine.decorators;

import com.sdeready.lld.vendingmachine.Coffee;

public class Sugar extends CoffeeAddon{

    public Sugar(Coffee coffee){
        super(coffee);
    }

    @Override
    public String getName() {
        return this.coffee.getName() + " + " + "Sugar";
    }

    @Override
    public Double getPrice() {
        return this.coffee.getPrice() + 1.0d;
    }
}
