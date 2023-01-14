package org.example;


import org.example.init.Initializer;
import org.example.servises.StockShop;

public class Main {
    public static void main(String[] args) {
        Initializer initializer = new Initializer();
        Application application = new Application(initializer.getConsoleManager(),initializer.getStockShop(),initializer.getStockService(),initializer.getCustomerService());
        application.firstMenu();
    }
}