package org.example.dao;

import org.example.entities.Stock;
import org.example.entities.User;

import java.sql.*;
import java.util.ArrayList;

public class StockDataBaseDAO {
    private static String SQL_LOGIN = "SELECT * FROM db_to_console_program.users WHERE Login = ? AND Password = ?;";
    private static String SQL_GET_ALL_STOCKS = "SELECT * FROM db_to_console_program.stocks;";
    private static String SQL_CREATE_ACCOUNT = "INSERT INTO `db_to_console_program`.`users` (`Login`, `Password`) VALUES (?, ?);";
    private static Connection connection = null;

    public ArrayList<Stock> getAllStocksFromDB() {
        ResultSet result = getResultSet(SQL_GET_ALL_STOCKS);
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

    //    public boolean createAccount(String login, String password){
//        return modifyDB(SQL_CREATE_ACCOUNT,login,password);
//    }
    public User login(String login, String password) {
        ResultSet result = getResultSet(SQL_LOGIN, login, password);
        try {
            if (result.next()) {
                return new User(result.getInt("id"), result.getString("login"), result.getString("password"));
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    public Connection getConnection() throws SQLException {
        if (connection == null) {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_to_console_program", "root", "root");
        }
        return this.connection;
    }

    private ResultSet getResultSet(String SQL, String... params) {
        ResultSet rs = null;
        try {
            PreparedStatement statement = (this.getConnection()).prepareStatement(SQL);
            for ( int i = 1; i <= params.length; i++ ) {
                statement.setString(i, params[i - 1]);
            }
            rs = statement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    private boolean modifyDB(String SQL, String... params) {
        boolean isModify = false;
        try {
            PreparedStatement statement = (this.getConnection()).prepareStatement(SQL);
            for ( int i = 1; i <= params.length; i++ ) {
                statement.setString(i, params[i - 1]);
            }
            isModify = statement.execute();
        } catch (Exception e) {
            return false;
        }
        return isModify;
    }

}
