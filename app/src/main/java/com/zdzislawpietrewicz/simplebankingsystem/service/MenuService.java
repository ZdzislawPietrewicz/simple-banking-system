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

        System.out.println("1. Balance");
        System.out.println("2. Add income");
        System.out.println("3. Do transfer");
        System.out.println("4. Close account");
        System.out.println("5. Log out");
        System.out.println("0. Exit");
        System.out.print(">");
    }


}
