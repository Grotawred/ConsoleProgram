package org.example;


import org.example.servises.StartMenu;
import org.example.servises.StockShop;

public class Main {
    public static void main(String[] args) {
        StockShop stockShop = new StockShop();
        StartMenu startMenu = new StartMenu(stockShop);
        startMenu.startMenu();
    }
}