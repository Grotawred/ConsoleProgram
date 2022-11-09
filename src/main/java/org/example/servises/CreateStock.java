package org.example.servises;

import org.example.dao.StockDAO;
import org.example.entities.Stock;

public class CreateStock {
    private ConsoleManager  consoleManager;
    private StockDAO stockDAO;
    public CreateStock(){
        consoleManager = new ConsoleManager();
        stockDAO = new StockDAO();
    }
    public void createStock(){
        String name;
        String price;
        String quantity;

        while(true){
            name = consoleManager.readStringFromConsole("Create name: ");
            price = consoleManager.readStringFromConsole("Create price: ");
            quantity = consoleManager.readStringFromConsole("How much of your stock: ");
            Stock stock = new Stock(name, price, quantity);
            stockDAO.createStock(name, price, quantity);
            break;
        }
    }
}
