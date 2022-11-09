package org.example.dao;

import org.example.entities.Stock;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StockDAO {
    private static String SQL_GET_ALL_STOCKS = "SELECT * FROM db_to_console_program.stocks;";
    private static String SQL_GET_QUANTITIES_OF_ALL_STOCKS = "SELECT quantity FROM db_to_console_program.stocks WHERE id = ?;";
    private static String SQL_GET_PRICE_OF_STOCK_BY_ID = "SELECT price FROM db_to_console_program.stocks WHERE id = ?;";
    private static String SQL_CRETE_NEW_STOCK = "INSERT INTO `db_to_console_program`.`stocks` (`name`, `price`, `quantity`) VALUES ('?', '?', '?');";
    private DataBaseUtility dataBase;
    public StockDAO(DataBaseUtility dataBase){
        this.dataBase = dataBase;
    }
    public int getPriceById(int userChoiceStockId){
        ResultSet resultSet = dataBase.getResultSet(SQL_GET_PRICE_OF_STOCK_BY_ID, userChoiceStockId);
        try {
            while(resultSet.next()){
                return resultSet.getInt("price");
            }
        }catch (SQLException e){
           throw new RuntimeException(e);
        }
        return 0;
    }

    public ArrayList<Stock> getAllStocksFromDB() {
        ResultSet result = dataBase.getResultSet(SQL_GET_ALL_STOCKS);
        ArrayList<Stock> stocks = new ArrayList<>();
        try {
            while (result.next()) {
                stocks.add(new Stock(result.getInt("id"),
                        result.getString("name"),
                        result.getInt("price"),
                        result.getInt("quantity")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return stocks;
    }
    public int quantitiesOfStocks(int stock_id) {
        ResultSet result = dataBase.getResultSet(SQL_GET_QUANTITIES_OF_ALL_STOCKS, stock_id);
        try {
            if (result.next()) {
                return result.getInt("quantity");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 0;
    }
    public boolean createStock(String name, String price, String quantity){
        return dataBase.modifyDB(SQL_CRETE_NEW_STOCK, name, price, quantity);
    }
}
