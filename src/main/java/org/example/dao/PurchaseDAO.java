package org.example.dao;

public class PurchaseDAO {
    private static String SQL_BUY_STOCK = "INSERT INTO db_to_console_program.purchases(customer_id, quantity, stock_id) VALUES (?, ?, ?);";
    private static String SQL_SELL_STOCK = "DELETE FROM db_to_console_program.purchases WHERE customer_id = ? AND stock_id = ? ;";
    private DataBaseUtility dataBasa;
    public PurchaseDAO(DataBaseUtility dataBasa){
        this.dataBasa = dataBasa;
    }

    public void buyStock(int stock_id, int customerId, int quantity){
        boolean result = dataBasa.modifyDB(SQL_BUY_STOCK, customerId, quantity, stock_id);
    }
    public void sellStock(int stock_id, int customerId){
        boolean result = dataBasa.modifyDB(SQL_SELL_STOCK,customerId, stock_id);
    }

}
