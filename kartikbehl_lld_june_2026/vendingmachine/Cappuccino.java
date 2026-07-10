package designpatterns.kartikbehl_lld_june_2026.vendingmachine;

public class Cappuccino extends Coffee {

    @Override
    public String getName() {
        return "Cappuccino";
    }

    @Override
    public Double getPrice() {
        return 12.0d;
    }
}
