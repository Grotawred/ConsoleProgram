package org.example.init;

import lombok.NoArgsConstructor;
import org.example.Application;
import org.example.dao.DataBaseUtility;
import org.example.dao.PurchaseDAO;
import org.example.dao.StockDAO;
import org.example.dao.UserDAO;
import org.example.servises.ConsoleManager;
import org.example.servises.CustomerService;
import org.example.servises.StockService;
import org.example.servises.StockShop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@NoArgsConstructor
public class Initializer {
    private static Connection connection = null;
    private DataBaseUtility dataBase;
    private StockDAO stockDAO;
    private UserDAO userDAO;
    private PurchaseDAO purchaseDAO;
    private ConsoleManager consoleManager;
    private StockService stockService;
    private StockShop stockShop;
    private Application application;
    private CustomerService customerService;
    public StockService getStockService(){
        if(stockService == null){
            stockService = new StockService(getStockDAO(),getConsoleManager(),getPurchaseDAO(),getUserDAO());
        }
        return stockService;
    }
    public CustomerService getCustomerService(){
        if(customerService == null){
            customerService = new CustomerService(getConsoleManager(),getUserDAO(),getStockShop());
        }
        return customerService;
    }
    public Application getApplication(){
        if(application == null){
            application = new Application(getConsoleManager(),getStockShop(),getStockService(),getCustomerService());
        }
        return application;
    }

    public StockShop getStockShop(){
        if(stockShop == null){
            stockShop = new StockShop(getStockDAO());
        }
        return stockShop;
    }

    public DataBaseUtility getDataBaseUtility() {
        if (dataBase == null) {
            dataBase = new DataBaseUtility(this);
        }
        return dataBase;
    }

    public StockDAO getStockDAO() {
        if (stockDAO == null) {
            stockDAO = new StockDAO(getDataBaseUtility());
        }
        return stockDAO;
    }

    public UserDAO getUserDAO() {
        if (userDAO == null) {
            userDAO = new UserDAO(getDataBaseUtility());
        }
        return userDAO;
    }

    public PurchaseDAO getPurchaseDAO() {
        if (purchaseDAO == null) {
            purchaseDAO = new PurchaseDAO(getDataBaseUtility());
        }
        return purchaseDAO;
    }

    public ConsoleManager getConsoleManager() {
        if (consoleManager == null) {
            consoleManager = new ConsoleManager(getStockDAO());
        }
        return consoleManager;
    }

    public Connection getConnection() {
        try {
            if (connection == null) {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_to_console_program", "root", "root");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
