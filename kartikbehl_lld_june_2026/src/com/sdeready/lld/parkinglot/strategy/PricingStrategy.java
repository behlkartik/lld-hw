package com.sdeready.lld.parkinglot.strategy;

public interface PricingStrategy {
    double getCharge(int hours);
}
