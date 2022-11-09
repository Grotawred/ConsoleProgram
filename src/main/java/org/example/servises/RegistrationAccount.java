package org.example.servises;

import org.example.dao.UserDAO;

public class RegistrationAccount {
    private ConsoleManager consoleManager;
    private UserDAO userDAO;
    public  void registrationCustomer(){
        String login;
        String password;
        boolean isCreated;
        int userChoiceNumber;

        while(true){
            login = consoleManager.readStringFromConsole("Create login: ");
            password = consoleManager.readStringFromConsole("Create password: ");
            isCreated = userDAO.createUser(login, password);
            break;
        }

    }
}
