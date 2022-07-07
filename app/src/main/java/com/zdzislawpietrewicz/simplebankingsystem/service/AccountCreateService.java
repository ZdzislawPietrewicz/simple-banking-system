package com.zdzislawpietrewicz.simplebankingsystem.service;

import com.zdzislawpietrewicz.simplebankingsystem.data.Account;
import com.zdzislawpietrewicz.simplebankingsystem.data.CreditCard;

import java.util.Random;

public class AccountCreateService {

    public static Account createAnAccount() {
        final int BANK_IDENTIFICATION_NUMBER = 400000;
        final int INITIAL_BALANCE = 0;
        int accountIdentifier = DatabaseConnectionService.assignAccountIdentifier();
        System.out.println("");
        long creditCardNumberWithoutCheckDigit = Long.valueOf(String.valueOf(BANK_IDENTIFICATION_NUMBER) + String.valueOf(accountIdentifier));
        int creditCardCheckDigit = createOrCheckCreditCardNumber(creditCardNumberWithoutCheckDigit);
        String creditCardNumberWithCheckDigit = String.valueOf(creditCardNumberWithoutCheckDigit * 10 + creditCardCheckDigit);
        CreditCard newCreditCard = new CreditCard(creditCardNumberWithCheckDigit, createPin(), INITIAL_BALANCE);
        Account newAccount = new Account(accountIdentifier, newCreditCard);
        System.out.println("Your card has been created");
        System.out.println("Your card number:");
        System.out.println(BANK_IDENTIFICATION_NUMBER + "" + accountIdentifier + "" + creditCardCheckDigit);
        System.out.println("Your card PIN:");
        System.out.println(newAccount.getCreditCard().getPin());
        System.out.println("");
        return newAccount;
    }

    private static String createPin() {
        Random random = new Random();
        String pin = "";
        for (int i = 0; i < 4; i++) {
            pin += (String.valueOf(random.nextInt(9) + 1));
        }
        return pin;
    }

    public static int createOrCheckCreditCardNumber(long customerCreditCardNumber) {
        long[] creditCardDigits = new long[15];
        int controlSum = 0;
        for (int i = 14; i >= 0; i--) {

            creditCardDigits[i] = customerCreditCardNumber % 10;
            customerCreditCardNumber = customerCreditCardNumber / 10;
            if (i % 2 == 0) {
                creditCardDigits[i] *= 2;
                if (creditCardDigits[i] > 9) {
                    creditCardDigits[i] -= 9;
                }
            }
            controlSum += creditCardDigits[i];
        }
        int controlNumber = ((10 - (controlSum % 10)) % 10);
        return controlNumber;
    }



}
