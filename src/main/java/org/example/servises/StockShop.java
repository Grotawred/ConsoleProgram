package org.example.servises;
import org.example.dao.StockDAO;
import org.example.entities.Stock;

import java.util.ArrayList;

public class StockShop {
    private ArrayList<Stock> actions = new ArrayList<>();
    private StockDAO dao;
    public StockShop(){
//        dao = new StockDAO();
    }
    public ArrayList<Stock> getAllStocks(){
        return dao.getAllStocksFromDB();
    }

    public ArrayList<Stock> getActions() {
        return actions;
    }

    public void printAction() {
        for( Stock product: actions) {
            System.out.println(product.toString());
        }
    }
}
