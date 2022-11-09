package org.example.servises;

public class StartMenu {
    private ConsoleManager consoleManager;
    private StockShop stockShop;
    private RegistrationAccount registrAccount;
    private LoggedToAccount loggedCustomer;

    public StartMenu(StockShop stockShop){
        this.stockShop = stockShop;
        consoleManager = new ConsoleManager();
        registrAccount = new RegistrationAccount();
        loggedCustomer = new LoggedToAccount(stockShop);
    }

    public StartMenu(){
    }

    public void startMenu(){
        int userChoiceNumber;

        link:
        while (true) {
            consoleManager.printMainMenu();
            userChoiceNumber = consoleManager.readNumberFromConsole(1, 4);
            consoleManager.clearTheConsole();//TODO implement clearing the console
            switch (userChoiceNumber) {
                case 1:
                    loggedCustomer.loggedCustomer();
                    break;
                case 2:
                    registrAccount.registrationCustomer();
                    break;
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
}
