package org.example.servises;

import org.example.dao.PurchaseDAO;
import org.example.entities.User;

public class LoggedInAccount {
    private ConsoleManager consoleManager;
    private BuyStocks buyStock;
    private CreateStock createStock;
    private SellStock sellStock;
    public LoggedInAccount(){
        consoleManager = new ConsoleManager();
        buyStock = new BuyStocks();
        createStock = new CreateStock();
        sellStock = new SellStock();
    }
    public void workWithLoggedUser(User user, StockShop stockShop) {
        int userChoiceNumber;
        link:
        while (true) {
            consoleManager.printLoggedMenu();
            userChoiceNumber = consoleManager.readNumberFromConsole(1, 6);
            switch (userChoiceNumber) {
                case 1:
                    consoleManager.printAllStocksToConsole(stockShop.getAllStocks());
                    break;
                case 2:
                    buyStock.buyStock(user);
                    break;
                case 3:
                    sellStock.sellStock(user);
                    break;
                case 4:
                    createStock.createStock();
                    break;
                case 5:
                    break link;
            }
        }
    }
}