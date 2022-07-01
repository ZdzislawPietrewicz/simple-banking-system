package com.zdzislawpietrewicz.simplebankingsystem.service;



import java.util.Scanner;

public class LoginValidationService {

    public static boolean loginValidator() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your card number");
        String userInputCardNumber = scanner.nextLine();
        System.out.println("Enter your PIN:");
        String userInputPin = scanner.nextLine();

        boolean areCredentialsValid=DatabaseConnectionService.checkCredentials(userInputCardNumber, userInputPin);
        return areCredentialsValid;


    }

}
