package org.example.servises;

import org.example.dao.PurchaseDAO;
import org.example.dao.StockDAO;
import org.example.dao.UserDAO;
import org.example.entities.Stock;
import org.example.entities.User;

import java.util.ArrayList;

public class SellStock {
    private ConsoleManager consoleManager;
    private StockDAO stockDAO;
    private PurchaseDAO purchaseDAO;
    private UserDAO userDAO;
    public SellStock(){
        consoleManager = new ConsoleManager();
        stockDAO = new StockDAO();
        purchaseDAO = new PurchaseDAO();
        userDAO = new UserDAO();
    }
    public void sellStock(User user){
        ArrayList<Stock> stocks = stockDAO.getAllStocksFromDB();
        int to = stocks.get(stocks.size()-1).getId();
        while(true) {
            System.out.println("Write id of stock to sell");
            int userChoiceStockId = consoleManager.readNumberFromConsole(1, to);
            System.out.println("Print number of stocks to sell");
            int userChoiceStockNumber = consoleManager.readQuantytiesOfStocks(userChoiceStockId);
            purchaseDAO.sellStock(userChoiceStockId, user.getId());
            user.setMoney(user.getMoney()+(stockDAO.getPriceById(userChoiceStockId)*userChoiceStockNumber));
            userDAO.updateMoney(user.getMoney(),user.getId());
            break;
            }
    }
}
