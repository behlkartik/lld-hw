package com.sdeready.lld.vendingmachine;

public abstract class Coffee {
    public abstract String getName();
    public abstract Double getPrice();

    @Override
    public String toString() {
        return this.getName() + "(" + this.getPrice() + ")";
    }
}
