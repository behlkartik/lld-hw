package designpatterns.kartikbehl_lld_june_2026.vendingmachine.decorators;

import designpatterns.kartikbehl_lld_june_2026.vendingmachine.Coffee;

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
