package com.zdzislawpietrewicz.simplebankingsystem.service;

import java.util.Scanner;

public class MenuService {
    public static void mainMenu() {
        System.out.println("1. Create an account");
        System.out.println("2. Log into account");
        System.out.println("0. Exit");
        System.out.print(">");
    }
    public static void loggedInMenu() {

        int userChoice;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1. Balance");
            System.out.println("2. Log out");
            System.out.println("0. Exit");
            System.out.print(">");
            userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1:
                    System.out.println("");
                    System.out.println("Balance: 0");
                    System.out.println("");
                    break;
                case 0:
                    System.out.println("");
                    System.out.println("Bye!");
                    System.exit(0);
                case 2:
                    System.out.println("");
                    System.out.println("You have successfully logged out!");
                    System.out.println("");
                default:
                    break;
            }
        } while (userChoice != 2);
    }
}
