package org.example;

import lombok.Builder;
import org.example.entities.User;
import org.example.servises.ConsoleManager;
import org.example.servises.CustomerService;
import org.example.servises.StockService;
import org.example.servises.StockShop;
@Builder
public class Application {
    private ConsoleManager consoleManager;
    private StockShop stockShop;
    private StockService stockService;
    private CustomerService customerService;
    public Application(ConsoleManager consoleManager, StockShop stockShop, StockService stockService, CustomerService customerService){
        this.stockService = stockService;
        this.consoleManager = consoleManager;
        this.stockShop = stockShop;
        this.customerService = customerService;
    }
    public void firstMenu(){
        int userChoiceNumber;

        link:
        while (true) {
            consoleManager.printMainMenu();
            userChoiceNumber = consoleManager.readNumberFromConsole(1, 4);
            consoleManager.clearTheConsole();
            switch (userChoiceNumber) {
                case 1:
                    User user =  customerService.loggedCustomer();
                    workWithLoggedUser(user);
                    break;
                case 2:
                    customerService.registrationCustomer();
                    break;
                case 3:
                    consoleManager.printAllStocksToConsole(stockShop.getAllStocks());
                    break;
                case 4:
                    break link;
            }
        }
    }
    public void workWithLoggedUser(User user) {
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
                    stockService.buyStock(user);
                    break;
                case 3:
                    stockService.sellStock(user);
                    break;
                case 4:
                    stockService.createStock();
                    break;
                case 5:
                    break link;
            }
        }
    }
}
