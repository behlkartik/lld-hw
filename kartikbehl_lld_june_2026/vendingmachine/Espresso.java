package designpatterns.kartikbehl_lld_june_2026.vendingmachine;

public class Espresso extends Coffee {

    @Override
    public String getName() {
        return "Espresso";
    }

    @Override
    public Double getPrice() {
        return 10.0d;
    }
}
