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
        String fileNameWithDatabase="standard_database.db";
        if(args[0].equals("-fileName")) {
            fileNameWithDatabase=args[1];
        }
        Scanner scanner = new Scanner(System.in);
        int userChoice;
        DatabaseConnectionService databaseConnectionService = new DatabaseConnectionService(fileNameWithDatabase);
        do {
            MenuService.mainMenu();
            userChoice = scanner.nextInt();
            scanner.nextLine();
            switch (userChoice) {
                case 1:
                    Account newAccount = AccountService.createAnAccount();
                    databaseConnectionService.addAccountToDatabase(newAccount);
                    break;
                case 2:
                    if (LoginValidationService.loginValidator()) {
                        MenuService.loggedInMenu();
                    } else System.out.println("Wrong card number or PIN!\n");
                    break;
                default:
                    break;
            }

        } while (userChoice != 0);
    }


}
