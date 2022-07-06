package com.zdzislawpietrewicz.simplebankingsystem.service;

import com.zdzislawpietrewicz.simplebankingsystem.data.Account;
import com.zdzislawpietrewicz.simplebankingsystem.data.CreditCard;

import java.util.Scanner;

public class AccountOperationsService {
    private CreditCard creditCard;

    public AccountOperationsService(String userCreditCardNumber) {
        Scanner scanner = new Scanner(System.in);
        int userChoice = 0;
        do {
            MenuService.loggedInMenu();
            userChoice = scanner.nextInt();
            scanner.nextLine();
            switch (userChoice) {
                case 1:
                    int balance=DatabaseConnectionService.checkBalance(userCreditCardNumber);
                    System.out.println("");
                    System.out.println("Balance: " + balance);
                    System.out.println("");
                    break;
                case 2:

                case 5:
                    System.out.println("");
                    System.out.println("You have successfully logged out!");
                    System.out.println("");
                    break;
                case 0:
                    System.out.println("");
                    System.out.println("Bye!");
                    System.exit(0);
                    break;
                default:
                    break;
            }
        } while (userChoice != 5);
    }
}

