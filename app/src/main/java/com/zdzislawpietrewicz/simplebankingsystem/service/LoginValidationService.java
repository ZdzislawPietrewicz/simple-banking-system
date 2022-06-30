package com.zdzislawpietrewicz.simplebankingsystem.service;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoginValidationService {
    public static boolean loginValidator(HashMap<String, String> accounts) {

        boolean areCredentialsValid = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your card number");
        String userInputCardNumber = scanner.nextLine();
        System.out.println("Enter your PIN:");
        String userInputPin = scanner.nextLine();
        for (Map.Entry<String, String> account : accounts.entrySet()) {
            if (account.getKey().equals(userInputCardNumber) && account.getValue().equals( userInputPin)) {
                areCredentialsValid = true;
                System.out.println("You have successfully logged in!");
                System.out.println(" ");

            } else areCredentialsValid = false;
        }
        return areCredentialsValid;
    }

}
