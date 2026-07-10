package designpatterns.kartikbehl_lld_june_2026.vendingmachine;

import designpatterns.kartikbehl_lld_june_2026.vendingmachine.decorators.Milk;
import designpatterns.kartikbehl_lld_june_2026.vendingmachine.decorators.Sugar;
import designpatterns.kartikbehl_lld_june_2026.vendingmachine.decorators.WhippedCream;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws Exception {
        Coffee coffee = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("====== Coffee Vending Machine ======");
        System.out.println("Choose Coffee:");
        System.out.println("1. Espresso");
        System.out.println("2. Cappuccino");
        System.out.println("3. Latte");
        System.out.println();
        System.out.println("Select:");
        int selectedCoffee = sc.nextInt();
        coffee = CoffeeFactory.getCoffee(selectedCoffee);
        System.out.println("Current Selection: "+coffee.getName());
        System.out.println("Current Total: "+coffee.getPrice());

        System.out.println("Add Milk? (y/n)");
        char selection = sc.next().charAt(0);
        if(selection == 'y'){
            coffee = new Milk(coffee);
        }
        System.out.println("Current Selection: "+coffee.getName());
        System.out.println("Current Total: "+coffee.getPrice());

        System.out.println("Add Sugar? (y/n)");
        selection = sc.next().charAt(0);
        if(selection == 'y'){
            coffee = new Sugar(coffee);
        }
        System.out.println("Current Selection: "+coffee.getName());
        System.out.println("Current Total: "+coffee.getPrice());

        System.out.println("Add Whipped Cream? (y/n)");
        selection = sc.next().charAt(0);
        if(selection == 'y'){
            coffee = new WhippedCream(coffee);
        }

        System.out.println("Coffee name: "+coffee.getName());
        System.out.println("Total Price: "+coffee.getPrice());
    }
}
