package com.sdeready.lld.parkinglot.strategy;

public class IncrementalPricingStrategy implements PricingStrategy {

    @Override
    public double getCharge(int hours) {
        return switch (hours){
            case 1, 2, 3 -> 20;
            default -> 20 + hours * 30;
        };
    }
}
