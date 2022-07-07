package com.zdzislawpietrewicz.simplebankingsystem.service;

import com.zdzislawpietrewicz.simplebankingsystem.data.Account;
import com.zdzislawpietrewicz.simplebankingsystem.data.CreditCard;

import javax.sound.midi.MidiFileFormat;
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
                    int balance = DatabaseConnectionService.checkBalance(userCreditCardNumber);
                    System.out.println("");
                    System.out.println("Balance: " + balance);
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("Enter income:");
                    int addIncome = scanner.nextInt();
                    DatabaseConnectionService.addIncome(addIncome, userCreditCardNumber);
                    System.out.println("Income was added!");
                    break;

                case 3:
                    System.out.println("Transfer");
                    System.out.println("Enter card number:");
                    String recipientCreditCardNumber = scanner.nextLine();
                    String creditCardNumberWithoutCheckDigit = recipientCreditCardNumber.substring(0, recipientCreditCardNumber.length() - 1);
                    String userCheckDigit = recipientCreditCardNumber.substring(recipientCreditCardNumber.length() - 1, recipientCreditCardNumber.length());
                    int generateCheckDigitLuhnAlorithm = AccountCreateService.createOrCheckCreditCardNumber(Long.valueOf(creditCardNumberWithoutCheckDigit));
                    if (generateCheckDigitLuhnAlorithm != Integer.valueOf(userCheckDigit))
                        System.out.println("Probably you made a mistake in the card number. Please try again!");
                    else if (!DatabaseConnectionService.existCreditCardNumber(recipientCreditCardNumber))
                        System.out.println("Such a card does not exist.");
                    else {
                        System.out.println("Enter how much money you want to transfer:");
                        int amountTransferMoney = scanner.nextInt();
                        if (DatabaseConnectionService.checkBalance(userCreditCardNumber) < amountTransferMoney)
                            System.out.println("Not enough money!");
                        else {
                            DatabaseConnectionService.transferMoney(userCreditCardNumber, recipientCreditCardNumber, amountTransferMoney);
                            System.out.println("Success!");
                        }

                    }


                    break;

                case 4:
                    DatabaseConnectionService.deleteAccount(userCreditCardNumber);
                    userChoice = 5; // go out to main menu
                    break;

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

