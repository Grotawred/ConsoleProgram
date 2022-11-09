package org.example.dao;

import org.example.entities.User;
import org.example.init.Initializer;

import java.sql.ResultSet;

public class UserDAO {
    private static String SQL_LOGIN = "SELECT * FROM db_to_console_program.users WHERE Login = ? AND Password = ?;";
    private static String SQL_CREATE_ACCOUNT = "INSERT INTO `db_to_console_program`.`users` (`Login`, `Password`) VALUES (?, ?);";
    private static String SQL_TO_SWITCH_MONEY = "UPDATE db_to_console_program.users SET money = ? WHERE (id =  ?);";
    private DataBaseUtility dataBaseUtility;
    public UserDAO(DataBaseUtility dataBaseUtility){
        this.dataBaseUtility = dataBaseUtility;
    }
    public boolean createUser(String login, String password){//TODO input user not login and password
        return dataBaseUtility.modifyDB(SQL_CREATE_ACCOUNT, login, password);
    }
    public User getUserByLoginAndPassword(String login, String password) {
        ResultSet result = dataBaseUtility.getResultSet(SQL_LOGIN, login, password);
        try {
            if (result.next()) {
                return new User(result.getInt("id"), result.getString("login"), result.getString("password"),result.getInt("money"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
    public void updateMoney(int money, int id){
        boolean result = dataBaseUtility.modifyDB(SQL_TO_SWITCH_MONEY,money,id);
    }
}
