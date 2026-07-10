package com.sdeready.designpatterns.creational.vendingmachine;

import com.sdeready.designpatterns.creational.vendingmachine.decorators.Milk;
import com.sdeready.designpatterns.creational.vendingmachine.decorators.Sugar;
import com.sdeready.designpatterns.creational.vendingmachine.decorators.WhippedCream;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws Exception {
        Coffee coffee = null;
        Scanner sc = new Scanner(System.in);
        int count = 0;
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
