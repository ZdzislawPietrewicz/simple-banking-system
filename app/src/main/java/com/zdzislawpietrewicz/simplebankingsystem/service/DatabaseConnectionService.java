package com.zdzislawpietrewicz.simplebankingsystem.service;

import org.sqlite.SQLiteDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnectionService {
    public DatabaseConnectionService() {
        String url="jdbc:sqlite:/Users/zdzislawpietrewicz/code/simple-banking-system/app/src/main/java/com/zdzislawpietrewicz/simplebankingsystem/db/abc.db";
        SQLiteDataSource sqLiteDataSource = new SQLiteDataSource();
        sqLiteDataSource.setUrl(url);
        try(Connection connection = sqLiteDataSource.getConnection()){
            try(Statement statement=connection.createStatement()){
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS card(" +
                    "id INTEGER PRIMARY KEY," +
                    "number VARCHAR (16),"+
                    "pin VARCHAR (5)," +
                    "balance INTEGER)");

            }

        }catch (SQLException e){
            e.printStackTrace();
        }



    }
}
