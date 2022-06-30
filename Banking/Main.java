import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userChoice;
        HashMap<Long, Integer> accounts = new HashMap<Long, Integer>();
        int accountIdentifier = 493832089;
        do {
            showMainMenu();
            userChoice = scanner.nextInt();
            scanner.nextLine();
            switch (userChoice) {
                case 1:
                    Account newAccount = createAnAccount(accountIdentifier);
                    accounts.put(newAccount.getCreditCardNumber(), newAccount.getPin());
                    accountIdentifier++;
                    break;
                case 2:
                    if (loginValidator(accounts)) {
                        logInAccount();
                    } else System.out.println("Wrong card number or PIN!\n");
                    break;
                default:
                    break;
            }

        } while (userChoice != 0);
    }

    private static void showMainMenu() {
        System.out.println("1. Create an account");
        System.out.println("2. Log into account");
        System.out.println("0. Exit");
        System.out.print(">");
    }


    private static boolean loginValidator(HashMap<Long, Integer> accounts) {

        boolean areCredentialsValid = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your card number");
        long userInputCardNumber = scanner.nextLong();
        System.out.println("Enter your PIN:");
        int userInputPin = scanner.nextInt();
        scanner.nextLine();
        for (Map.Entry<Long, Integer> account : accounts.entrySet()) {
            if (account.getKey() == userInputCardNumber && account.getValue().intValue() == userInputPin) {
                areCredentialsValid = true;
                break;

            } else areCredentialsValid = false;
        }
        return areCredentialsValid;
    }

    private static void logInAccount() {
        System.out.println("You have successfully logged in!");
        System.out.println(" ");
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
