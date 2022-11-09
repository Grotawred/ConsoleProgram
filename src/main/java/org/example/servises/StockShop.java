package org.example.servises;
import org.example.dao.StockDataBaseDAO;
import org.example.entities.Stock;

import java.util.ArrayList;

public class StockShop {
    private ArrayList<Stock> actions = new ArrayList<>();
    private StockDataBaseDAO dao;
    public StockShop(){
        dao = new StockDataBaseDAO();
    }
    public ArrayList<Stock> getAllStocks(){
        return dao.getAllStocksFromDB();
    }
//    public Stock addAction(String name, int price) {
//        return new Stock(name, price);
//    }
    public ArrayList<Stock> getActions() {
        return actions;
    }

    public void printAction() {
        for( Stock product: actions) {
            System.out.println(product.toString());
        }
    }
}
