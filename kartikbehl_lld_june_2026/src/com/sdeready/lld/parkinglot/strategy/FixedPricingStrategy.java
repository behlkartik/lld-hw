package com.sdeready.lld.parkinglot.strategy;

public class FixedPricingStrategy implements PricingStrategy {
    @Override
    public double getCharge(int hours) {
        return (hours + 1) * 10.0d;
    }
}
