package org.example.dao;

import org.example.entities.Stock;
import org.example.entities.User;

import java.sql.ResultSet;

public class PurchaseDAO {
    private static final String SQL_BUY_STOCK = "INSERT INTO db_to_console_program.purchases(customer_id, quantity, stock_id) VALUES (?, ?, ?);";
    private static final String SQL_SELL_STOCK = "DELETE FROM db_to_console_program.purchases WHERE customer_id = ? AND stock_id = ? ;";
    private static final String SQL_GET_QUANTITIES_OF_BOUGHT_STOCKS = "SELECT quantity FROM db_to_console_program.purchases WHERE customer_id = ? AND stock_id = ? ;";
    private DataBaseUtility dataBasa;
    public PurchaseDAO(DataBaseUtility database){
        this.dataBasa = database;
    }

    public void buyStock(int stock_id, int customerId, int quantity){
        boolean result = dataBasa.modifyDB(SQL_BUY_STOCK, customerId, quantity, stock_id);
    }
    public void sellStock(int stock_id, int customerId){
        boolean result = dataBasa.modifyDB(SQL_SELL_STOCK,customerId, stock_id);
    }
    public int getQuantitiesOfBoughtStocks(User user, int id){
        ResultSet result = dataBasa.getResultSet(SQL_GET_QUANTITIES_OF_BOUGHT_STOCKS , user.getId(), id);
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

}
