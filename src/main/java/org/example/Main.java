package org.example;

import org.example.dao.StockDataBaseDAO;
import org.example.entities.Stock;
import org.example.entities.User;
import org.example.servises.ConsoleManager;
import org.example.servises.StockShop;

import java.util.ArrayList;

public class Main {
    private static ConsoleManager consoleManager = new ConsoleManager();
    private static StockDataBaseDAO dao = new StockDataBaseDAO();
    private static StockShop stockShop = new StockShop();

    public static void main(String[] args) {
        int userChoiceNumber;

        link:
        while (true) {
            consoleManager.clearTheConsole();
            consoleManager.printMainMenu();
            userChoiceNumber = consoleManager.readNumberFromConsole(1, 4);
            switch (userChoiceNumber) {
                case 1:
                    loggedCustomer();
                    break;
//                case 2:
//                    createdCustomer();
//                    consoleManager.printLoginedMenu();
//                    break link;
                case 3:
                    consoleManager.printAllStocksToConsole(stockShop.getAllStocks());
                    break;
                case 4:
                    break link;
                default:
                    break link;
            }
        }

    }

    //    public static void createdCustomer(){
//        String login;
//        String password;
//        boolean isCreated;
//
//        login = consoleManager.readStringFromConsole("Create Login: ");
//        password = consoleManager.readStringFromConsole("Create Password: ");
//        isCreated = dao.createAccount(login, password);
//
//        System.out.println("User menu:");
//
//    }
    public static void loggedCustomer() {
        String login;
        String password;
        User user;
        int userChoiceNumber;

        while (true) {
            login = consoleManager.readStringFromConsole("Input Login: ");
            password = consoleManager.readStringFromConsole("Input Password: ");
            user = dao.login(login, password);

            if (user == null) {
                consoleManager.printRetryLoginMenu();
                userChoiceNumber = consoleManager.readNumberFromConsole(1, 2);

                if (userChoiceNumber == 1) {
                    continue;
                }
                break;
            }
            break;
        }
        workWithLoggedUser(user);
    }

    public static void workWithLoggedUser(User user) {
        int userChoiceNumber;
        link:while(true){
            consoleManager.printLoggedMenu();
            userChoiceNumber = consoleManager.readNumberFromConsole(1,6);
            switch (userChoiceNumber){
                case 1:
                    consoleManager.printAllStocksToConsole(stockShop.getAllStocks());
                    break;
                case 2:
                    buyStock(user);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    break link;
            }
        }


    }
    public static void buyStock(User user){
        ArrayList<Stock> stocks = dao.getAllStocksFromDB();
        int to = stocks.get(stocks.size()-1).getId();
        System.out.println("Write id of stock to buy");
        int userChoiceStockId = consoleManager.readNumberFromConsole(1,to);
        System.out.println("Print number of stocks");
        int userChoiceStockNumber = consoleManager.readNumberFromConsole();
        //TODO
    }


}