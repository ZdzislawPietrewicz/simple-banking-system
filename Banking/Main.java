import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userChoice;
        boolean areCredentialsGood;
        BigInteger customerAccount=null;
        int pin=0;
        int totalNumberOfCustomers=0;
        do {
            showMainMenu();
            userChoice = scanner.nextInt();
            scanner.nextLine();
            switch (userChoice) {
                case 1:
                    customerAccount = createAnAccount(++totalNumberOfCustomers);
                    pin=6826;
                    break;
                case 2:
                    areCredentialsGood = checkCredentials(customerAccount,pin);
                    if (areCredentialsGood) {
                        logInAccount();
                    } else System.out.println("Wrong card number or PIN!\n");
                    ;
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

    private static BigInteger createAnAccount(int numberOfCustomers) {
        System.out.println("");
        BigInteger customerAccountNumber = new BigInteger("4000004938320895").add(BigInteger.valueOf(numberOfCustomers));
        System.out.println("Your card has been created");
        System.out.println("Your card number:");
        System.out.println(customerAccountNumber);
        System.out.println("Your card PIN:");
        System.out.println("6826");
        System.out.println("");
        return customerAccountNumber;
    }

    private static boolean checkCredentials(BigInteger customerNumber, int pin) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your card number");
        BigInteger userInputCardNumber = scanner.nextBigInteger();
        System.out.println("Enter your PIN:");
        int userInputPin = scanner.nextInt();
        scanner.nextLine();
        if (userInputCardNumber.equals(customerNumber) && userInputPin== pin) {
            return true;
        } else return false;
    }

    private static void logInAccount() {

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
                    System.out.println("Balance: 0");
                    break;
                case 0:
                    System.exit(0);
                case 2:
                    System.out.println("You have successfully logged out!");
                default:
                    break;
            }
        } while ( userChoice != 2);
    }


}
