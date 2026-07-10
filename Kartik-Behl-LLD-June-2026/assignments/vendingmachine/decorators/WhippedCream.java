package com.sdeready.designpatterns.creational.vendingmachine.decorators;

import com.sdeready.designpatterns.creational.vendingmachine.Coffee;

public class WhippedCream extends CoffeeAddon{

    public WhippedCream(Coffee coffee){
        super(coffee);
    }

    @Override
    public String getName() {
        return this.coffee.getName() + "+" + "Whipped Cream";
    }

    @Override
    public Double getPrice() {
        return this.coffee.getPrice() + 3.0d;
    }
}
