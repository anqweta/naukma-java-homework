package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static void main() {

        Product funkoPop = new Product("Фігурка FunkoPop", 1, 800);
        Product pot = new Product("Кастрюля", 2, 1500);
        Product oilPaint = new Product("Олійні фарби Rosa Studio", 3, 1700);

        ArrayList<Product> products = new ArrayList<Product>(List.of(funkoPop, pot, oilPaint));
        VendingMachine vendingMachine = new VendingMachine(products);
        String[] affordableProducts = vendingMachine.getProductNames();
        System.out.println("Доступні товари: " + Arrays.toString(affordableProducts));
        vendingMachine.insertMoney(1000);
        vendingMachine.selectProduct(2);
        vendingMachine.insertMoney(2700);
        vendingMachine.selectProduct(2);
        System.out.println("Решта: " + vendingMachine.getChange());

    }
}
