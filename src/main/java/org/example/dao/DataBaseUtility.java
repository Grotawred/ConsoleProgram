package org.example.dao;

import org.example.init.Initializer;

import java.sql.*;

public class DataBaseUtility {
    private Initializer initializer;
    public DataBaseUtility(){}
    public DataBaseUtility(Initializer initializer){
        this.initializer = initializer;
    }
    public ResultSet getResultSet(String SQL) {
        ResultSet rs = null;
        try {
            Statement statement = (initializer.getConnection()).createStatement();

            rs = statement.executeQuery(SQL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    public ResultSet getResultSet(String SQL, String... params) {
        ResultSet rs = null;
        try {
            PreparedStatement statement = (initializer.getConnection()).prepareStatement(SQL);
            for ( int i = 1; i <= params.length; i++ ) {
                statement.setString(i, params[i - 1]);
            }
            rs = statement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    public ResultSet getResultSet(String SQL, Integer... params) {
        ResultSet rs = null;
        try {
            PreparedStatement statement = (initializer.getConnection()).prepareStatement(SQL);
            for ( int i = 1; i <= params.length; i++ ) {
                statement.setInt(i, params[i - 1]);
            }
            rs = statement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public boolean modifyDB(String SQL, String... params) {
        boolean isModify = false;
        try {
            PreparedStatement statement = (initializer.getConnection()).prepareStatement(SQL);
            for ( int i = 1; i <= params.length; i++ ) {
                statement.setString(i, params[i - 1]);
            }
            isModify = statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return isModify;
    }
    public boolean modifyDB(String SQL, Integer...params){
        boolean isModify = false;
        try {
            PreparedStatement statement = (initializer.getConnection()).prepareStatement(SQL);
            for ( int i = 1; i <= params.length; i++ ) {
                statement.setInt(i, params[i - 1]);
            }
            isModify = statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return isModify;
    }
}
