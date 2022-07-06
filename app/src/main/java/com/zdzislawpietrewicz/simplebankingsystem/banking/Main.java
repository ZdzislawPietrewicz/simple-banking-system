package com.zdzislawpietrewicz.simplebankingsystem.banking;

import com.zdzislawpietrewicz.simplebankingsystem.data.Account;
import com.zdzislawpietrewicz.simplebankingsystem.service.*;


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
                    Account newAccount = AccountCreateService.createAnAccount();
                    databaseConnectionService.addAccountToDatabase(newAccount);
                    break;
                case 2:
                    String userCreditCardNumber=LoginValidationService.loginValidator();
                    if (userCreditCardNumber!=null) {
                        AccountOperationsService accountOperationsService = new AccountOperationsService(userCreditCardNumber);
                    } else System.out.println("Wrong card number or PIN!\n");
                    break;
                default:
                    break;
            }

        } while (userChoice != 0);
    }


}
