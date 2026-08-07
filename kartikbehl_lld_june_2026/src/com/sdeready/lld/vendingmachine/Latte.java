package designpatterns.kartikbehl_lld_june_2026.vendingmachine;

public class Latte extends Coffee {


    @Override
    public String getName() {
        return "Latte";
    }

    @Override
    public Double getPrice() {
        return 15.0d;
    }
}
