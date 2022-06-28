import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int TOTAL_ACCOUNT_SUPPLY = 10000;
        Scanner scanner = new Scanner(System.in);
        int userChoice;
        boolean areCredentialsValid;
        Account[] accounts = new Account[TOTAL_ACCOUNT_SUPPLY];
        int pin = 0;
        int accountIdentifier = 493832089;
        int initialAccountIdentifier = 493832089;
        do {
            showMainMenu();
            userChoice = scanner.nextInt();
            scanner.nextLine();
            switch (userChoice) {
                case 1:
                    accounts[accountIdentifier-initialAccountIdentifier] = createAnAccount(accountIdentifier);
                    accountIdentifier++;
                    pin = 6826;
                    break;
                case 2:
                    areCredentialsValid = loginValidator(accounts);
                    if (areCredentialsValid) {
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

    private static Account createAnAccount(int accountIdentifier) {
        int bankIdentificationNumber = 400000;
        System.out.println("");
        BigInteger creditCardNumberWithoutCheckDigit = new BigInteger(String.valueOf(bankIdentificationNumber) + String.valueOf(accountIdentifier));
        int creditCardCheckDigit = createCreditCardNumber(creditCardNumberWithoutCheckDigit);
        BigInteger customerCreditCardNumberWithCheckDigit = creditCardNumberWithoutCheckDigit.multiply(BigInteger.TEN).add(BigInteger.valueOf(creditCardCheckDigit));
        Account account = new Account();
        account.setAccountIdentifier(accountIdentifier);
        account.setPin(createPin());
        account.setCreditCardNumber(customerCreditCardNumberWithCheckDigit);
        System.out.println("Your card has been created");
        System.out.println("Your card number:");
        System.out.println(bankIdentificationNumber + "" + accountIdentifier + "" + creditCardCheckDigit);
        System.out.println("Your card PIN:");
        System.out.println(account.getPin());
        System.out.println("");
        return account;
    }

    private static int createPin() {
        Random random = new Random();
        return random.nextInt(9999)+1;
    }

    private static int createCreditCardNumber(BigInteger customerCreditCardNumber) {
        int[] creditCardDigits = new int[15];
        int controlSum = 0;
        for (int i = 14; i >= 0; i--) {
            creditCardDigits[i] = customerCreditCardNumber.remainder(BigInteger.TEN).intValue();
            customerCreditCardNumber = customerCreditCardNumber.divide(BigInteger.valueOf(10));
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

    private static boolean loginValidator(Account [] accounts) {

        boolean areCredentialsValid=false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your card number");
        BigInteger userInputCardNumber = scanner.nextBigInteger();
        System.out.println("Enter your PIN:");
        int userInputPin = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < accounts.length; i++) {
            if(accounts[i].getCreditCardNumber()==userInputCardNumber && accounts[i].getPin()==userInputPin)
                areCredentialsValid=true;
            else areCredentialsValid=false;
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
