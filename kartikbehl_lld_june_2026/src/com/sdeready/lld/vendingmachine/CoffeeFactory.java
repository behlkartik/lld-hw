package com.sdeready.lld.vendingmachine;

public class CoffeeFactory {
    public static Coffee getCoffee(int selectedOption) throws Exception {
        return switch (selectedOption){
            case 1 -> new Espresso();
            case 2 -> new Cappuccino();
            case 3 -> new Latte();
            default -> throw new Exception("Wrong option selected");
        };
    }
}
