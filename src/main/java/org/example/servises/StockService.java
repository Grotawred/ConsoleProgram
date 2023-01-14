package org.example.servises;

import lombok.NoArgsConstructor;
import org.example.Application;
import org.example.dao.PurchaseDAO;
import org.example.dao.StockDAO;
import org.example.dao.UserDAO;
import org.example.entities.Stock;
import org.example.entities.User;
import org.example.init.Initializer;

import java.util.ArrayList;
public class StockService {
    private final StockDAO stockDAO;
    private final ConsoleManager consoleManager;
    private final PurchaseDAO purchaseDAO;
    private final UserDAO userDAO;
    public StockService(StockDAO stockDAO, ConsoleManager consoleManager, PurchaseDAO purchaseDAO, UserDAO userDAO){
        System.out.println("StockService Constructor");
        this.stockDAO = stockDAO;
        this.consoleManager = consoleManager;
        this.purchaseDAO = purchaseDAO;
        this.userDAO = userDAO;
    }
    public void sellStock(User user){
        ArrayList<Stock> stocks = stockDAO.getAllStocksFromDB();
        int to = stocks.get(stocks.size()-1).getId();
        while(true) {
            System.out.println("Write id of stock to sell");
            int userChoiceStockId = consoleManager.readNumberFromConsole(1, to);
            System.out.println("Print number of stocks to sell");
            int userChoiceStockNumber = consoleManager.readQuantitiesOfStocks(userChoiceStockId);
            Stock stock = stockDAO.getStockById(userChoiceStockId);
            int quantity = stock.getQuantity();
            if(quantity >= purchaseDAO.getQuantitiesOfBoughtStocks(user,stock.getId()) || userChoiceStockNumber <= purchaseDAO.getQuantitiesOfBoughtStocks(user,stock.getId())){
                purchaseDAO.sellStock(userChoiceStockNumber, user.getId());
                userDAO.updateMoney(user.getMoney() + stockDAO.getPriceById(userChoiceStockId), user.getId());
                break;
            }
        }
    }
    public void buyStock(User user){
        ArrayList<Stock> stocks = stockDAO.getAllStocksFromDB();
        int to = stocks.get(stocks.size()-1).getId();
        while(true) {
            System.out.println("Write id of stock to buy");
            int userChoiceStockId = consoleManager.readNumberFromConsole(1, to);
            System.out.println("Print number of stocks");
            int userChoiceStockNumber = consoleManager.readQuantitiesOfStocks(userChoiceStockId);
            if(user.getMoney()>stockDAO.getPriceById(userChoiceStockId)){
                purchaseDAO.buyStock(userChoiceStockId, user.getId(),userChoiceStockNumber);
                user.setMoney(user.getMoney()-(stockDAO.getPriceById(userChoiceStockId)*userChoiceStockNumber));
                userDAO.updateMoney(user.getMoney()-(stockDAO.getPriceById(userChoiceStockId)*userChoiceStockNumber),user.getId());
                break;
            }
        }
    }
    public void createStock(){
        String name;
        String price;
        String quantity;

            name = consoleManager.readStringFromConsole("Create name: ");
            price = consoleManager.readStringFromConsole("Create price: ");
            quantity = consoleManager.readStringFromConsole("How much of your stock: ");
            stockDAO.createStock(name, price, quantity);
    }
}
