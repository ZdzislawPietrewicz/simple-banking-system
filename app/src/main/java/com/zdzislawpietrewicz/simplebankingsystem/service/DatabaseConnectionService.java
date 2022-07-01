package com.zdzislawpietrewicz.simplebankingsystem.service;

import com.zdzislawpietrewicz.simplebankingsystem.data.Account;
import org.sqlite.SQLiteDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnectionService {
    private static SQLiteDataSource sqLiteDataSource;
    String urlToDatabase = "jdbc:sqlite:/Users/zdzislawpietrewicz/code/simple-banking-system/app/src/main/java/" +
            "com/zdzislawpietrewicz/simplebankingsystem/db/abc.db";


    public DatabaseConnectionService() {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS card(" +
                "id INTEGER NOT NULL," +
                "number VARCHAR (16) NOT NULL," +
                "pin VARCHAR (5) NOT NULL," +
                "balance INTEGER)";
        sqLiteDataSource = new SQLiteDataSource();
        sqLiteDataSource.setUrl(urlToDatabase);
        try (Connection connection = sqLiteDataSource.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(createTableQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addAccountToDatabase(Account newAccount) {
        String addToDatabaseQuery = "INSERT INTO card(number, pin, balance) VALUES  (" + newAccount.getCreditCard().getCreditCardNumber() + ", " +
                newAccount.getCreditCard().getPin() + ", " + newAccount.getCreditCard().getBalance() + ")";
        try (Connection connection = sqLiteDataSource.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(addToDatabaseQuery);
        } catch (SQLException e) {
            System.out.println(addToDatabaseQuery);
            e.printStackTrace();
            System.out.println(addToDatabaseQuery);
        }
    }

    public static int assignAccountIdentifier() {
        String query = "SELECT number FROM card";
        String lastCreditCardNumber = "";
        int accountIdentifier = 0;
        try (Connection connection = sqLiteDataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                lastCreditCardNumber = resultSet.getString("number");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (!lastCreditCardNumber.equals("")) {
            accountIdentifier = Integer.valueOf(lastCreditCardNumber.substring(6, 15)) + 1;
        } else {
            accountIdentifier = 493832089;
        }
        return accountIdentifier;

    }

    public static boolean checkCredentials(String userInputCreditCardNumber, String userInputCreditCardPin) {
        String queryCredentials = "SELECT number, pin FROM card";
        String creditCardNumber = "";
        String creditCardPin = "";
        boolean areCredentialsValid = false;
        try (Connection connection = sqLiteDataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(queryCredentials)) {
            while (resultSet.next()) {
                creditCardNumber = resultSet.getString("number");
                if (creditCardNumber.equals(userInputCreditCardNumber)) {
                    creditCardPin = resultSet.getString("pin");
                    if (creditCardPin.equals(userInputCreditCardPin)) {
                        areCredentialsValid = true;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return areCredentialsValid;
    }


}


