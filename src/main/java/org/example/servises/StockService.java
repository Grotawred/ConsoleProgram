package org.example.servises;

import org.example.dao.StockDAO;
import org.example.entities.Stock;
import org.example.entities.User;
import org.example.init.Initializer;

public class StockService {
    private StockDAO stockDAO;
    public StockService(Initializer initializer){
        stockDAO = initializer.getStockDAO();
    }
    public void sellStock(Stock stock, User user){
        int quantity = stock.getQuantity();
        //provetit kilkist stocksiv
        //yaksho vse harasho to prodatu
        //dodati koristuvachy groshi
    }
    public void buyStock(){

    }
}
