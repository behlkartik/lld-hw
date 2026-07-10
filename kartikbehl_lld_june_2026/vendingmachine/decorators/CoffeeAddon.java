package designpatterns.kartikbehl_lld_june_2026.vendingmachine.decorators;

import designpatterns.kartikbehl_lld_june_2026.vendingmachine.Coffee;

public abstract class CoffeeAddon extends Coffee {
    protected Coffee coffee;

    CoffeeAddon(Coffee coffee){
        super();
        this.coffee = coffee;
    }
}
