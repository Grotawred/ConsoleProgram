package org.example.servises;

import org.example.dao.PurchaseDAO;
import org.example.dao.StockDAO;
import org.example.dao.UserDAO;
import org.example.entities.Stock;
import org.example.entities.User;

import java.util.ArrayList;

public class BuyStocks {
    private ConsoleManager consoleManager;
    private StockDAO stockDAO;
    private PurchaseDAO purchaseDAO;
    private UserDAO userDAO;
    public BuyStocks(){
//        consoleManager = new ConsoleManager();
//        stockDAO = new StockDAO();
//        purchaseDAO = new PurchaseDAO();
//         userDAO = new UserDAO();
    }
    public void buyStock(User user){
        ArrayList<Stock> stocks = stockDAO.getAllStocksFromDB();
        int to = stocks.get(stocks.size()-1).getId();
        while(true) {
            System.out.println("Write id of stock to buy");
            int userChoiceStockId = consoleManager.readNumberFromConsole(1, to);
            System.out.println("Print number of stocks");
            int userChoiceStockNumber = consoleManager.readQuantytiesOfStocks(userChoiceStockId);
            if(user.getMoney()>stockDAO.getPriceById(userChoiceStockId)){
                purchaseDAO.buyStock(userChoiceStockId, user.getId(),userChoiceStockNumber);
                user.setMoney(user.getMoney()-(stockDAO.getPriceById(userChoiceStockId)*userChoiceStockNumber));
                userDAO.updateMoney(user.getMoney()-(stockDAO.getPriceById(userChoiceStockId)*userChoiceStockNumber),user.getId());
                break;
            }else {
                continue;
            }
        }
    }
}
