package com.zdzislawpietrewicz.simplebankingsystem.banking;

import com.zdzislawpietrewicz.simplebankingsystem.data.Account;
import com.zdzislawpietrewicz.simplebankingsystem.service.AccountService;
import com.zdzislawpietrewicz.simplebankingsystem.service.DatabaseConnectionService;
import com.zdzislawpietrewicz.simplebankingsystem.service.LoginValidationService;
import com.zdzislawpietrewicz.simplebankingsystem.service.MenuService;


import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userChoice;
        HashMap<String, String> accounts = new HashMap<String, String>();
        int accountIdentifier = 493832089;
        DatabaseConnectionService databaseConnectionService = new DatabaseConnectionService();
        do {
           MenuService.mainMenu();
            userChoice = scanner.nextInt();
            scanner.nextLine();
            switch (userChoice) {
                case 1:
                    Account newAccount = AccountService.createAnAccount(accountIdentifier);
                    accounts.put(newAccount.getCreditCard().getCreditCardNumber(), newAccount.getCreditCard().getPin());
                    accountIdentifier++;
                    break;
                case 2:
                    if (LoginValidationService.loginValidator(accounts)) {
                        MenuService.loggedInMenu();
                    } else System.out.println("Wrong card number or PIN!\n");
                    break;
                default:
                    break;
            }

        } while (userChoice != 0);
    }









}
