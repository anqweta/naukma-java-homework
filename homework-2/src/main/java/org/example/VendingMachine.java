package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class VendingMachine {

    private Product[] products;
    private double balance;

    public VendingMachine(ArrayList<Product> products) {
        this.products = products.toArray(new Product[0]);
    }

    public double getBalance() {
        return balance;
    }

    public String[] getProductNames() {
        String[] names = new String[products.length];
        for (int i = 0; i < products.length; i++) {
            names[i] = products[i].getName();
        }
        return names;
    }

    public void insertMoney(double amount) {
        if (amount >= 0) {
            balance += amount;
        } else {
            System.out.println("Invalid amount");
        }
    }

    public Product selectProduct(int id) {
        for (Product product : products) {
            if (product.getID() == id) {
                System.out.println("Товар за вашим запитом знайдено! Ціна: " + product.getPrice());
                if (balance >= product.getPrice()) {
                    balance -= product.getPrice();
                    System.out.println("Товар куплено! Поточний баланс: " + getBalance());
                    return product;
                }
            }
        }
        System.out.println("У вас недостатньо коштів для покупки! Поточний баланс: " + getBalance());
        return null;
    }

    public double getChange() {
        double change = this.balance;
        this.balance = 0;
        return change;
    }

}
