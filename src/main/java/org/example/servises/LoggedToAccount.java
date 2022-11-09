package org.example.servises;

import org.example.dao.UserDAO;
import org.example.entities.User;

public class LoggedToAccount {
    private ConsoleManager consoleManager;
    private StockShop stockShop;
    private LoggedInAccount loggedInAccount;
    private UserDAO userDAO;
    public LoggedToAccount(StockShop stockShop){
        this.stockShop = stockShop;
        loggedInAccount = new LoggedInAccount();
        userDAO = new UserDAO();
        consoleManager = new ConsoleManager();
    }
    public void loggedCustomer() {
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
        loggedInAccount.workWithLoggedUser(user,stockShop);
    }
}
