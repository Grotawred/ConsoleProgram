package org.example.servises;

import org.example.Application;
import org.example.dao.UserDAO;
import org.example.entities.User;
import org.example.init.Initializer;

public class CustomerService {
    private ConsoleManager consoleManager;
    private UserDAO userDAO;
    private StockShop stockShop;
    public CustomerService(ConsoleManager consoleManager, UserDAO userDAO, StockShop stockShop){
        System.out.println("CustomerService Constructor");
        this.consoleManager = consoleManager;
        this.userDAO = userDAO;
        this.stockShop = stockShop;
    }
    public User loggedCustomer() {
        String login;
        String password;
        User user;
        int userChoiceNumber;

        while (true) {
            login = consoleManager.readStringFromConsole("Input Login: ");
            password = consoleManager.readStringFromConsole("Input Password: ");
            user = userDAO.getUserByLoginAndPassword(login, password);

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
        return user;
    }

    public void registrationCustomer() {
        String login;
        String password;
        String money;
        boolean isCreated = false;

        while (!isCreated) {
            login = consoleManager.readStringFromConsole("Create login: ");
            password = consoleManager.readStringFromConsole("Create password: ");
            money = consoleManager.readStringFromConsole("How many money do you need: ");
            isCreated = userDAO.createUser(login, password, money);
            break;
        }
    }
}
