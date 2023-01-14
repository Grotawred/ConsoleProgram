package org.example.servises;
import org.example.dao.StockDAO;
import org.example.entities.Stock;

import java.util.ArrayList;

public class StockShop {
    private final ArrayList<Stock> actions = new ArrayList<>();
    private StockDAO dao;
    public StockShop(StockDAO stockDAO){
        dao = stockDAO;
    }
    public ArrayList<Stock> getAllStocks() {
        return dao.getAllStocksFromDB();
    }

    public void printAction() {
        for( Stock product: actions) {
            System.out.println(product.toString());
        }
    }
}
