package org.example.servises;

import org.example.dao.StockDAO;
import org.example.entities.Stock;
import org.example.init.Initializer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleManager {
    private static Scanner scanner = new Scanner(System.in);
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private StockDAO stockDAO;

    public ConsoleManager(StockDAO stockDAO) {
        this.stockDAO = stockDAO;
    }

    public void printAllStocksToConsole(ArrayList<Stock> stocks){
        stocks.forEach((x)-> System.out.println(x.toString()));
    }
    public String readStringFromConsole(){
        return scanner.nextLine();
    }
    public String readStringFromConsole(String message){
        System.out.println(message);
        String line = null;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return line;
    }
    public void clearTheConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public void printMainMenu(){
        System.out.println("1-login to account");
        System.out.println("2-creat account");
        System.out.println("3-print all stocks");
        System.out.println("4-exit");
    }
    public void printRetryLoginMenu(){
        System.out.println("1-try another login or password");
        System.out.println("2-exit");
    }
    public void printLoggedMenu(){
        System.out.println("1-show stocks list");
        System.out.println("2-buy stock");
        System.out.println("3-sell stock");
        System.out.println("4-create stock");
        System.out.println("5-back");
    }
    public int readQuantytiesOfStocks(int stock_id){
        int fromCopy = 1;
        int to = stockDAO.quantitiesOfStocks(stock_id);
        int number;
        while(true){
            try{
                int from = fromCopy;
                number = scanner.nextInt();
                for(;from<=to;from++){
                    if(number==from){
                        return number;
                    }
                }
                System.out.println("Please input number beetween "+ fromCopy + " and"+ to);
            }catch (Exception e){
                System.out.print("Please input positiv valid number: ");
                continue;
            }
        }
    }
    public int readNumberFromConsole(int from, int to){
        int fromCopy = from;
        int number;
        while(true) {
            try {
                from = fromCopy;
                number = scanner.nextInt();
                for(;from<=to;from++){
                    if(number==from){
                        return number;
                    }
                }
                System.out.println("Please input number between "+ fromCopy + " and "+ to);
            }catch (Exception e){
                System.out.print("Please input positive valid number: ");
                continue;
            }
        }
    }
    public int readNumberFromConsole(){
        int number;
        while(true) {
            try {
                number = scanner.nextInt();
                if(number<0){
                    System.out.println("Number must be bigger than 0");
                }
            }catch (Exception e){
                System.out.print("Please input positive valid number: ");
                continue;
            }
        }
    }
}
