import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoginValidationService {
    public static boolean loginValidator(HashMap<String, String> accounts) {

        boolean areCredentialsValid = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your card number");
        long userInputCardNumber = scanner.nextLong();
        System.out.println("Enter your PIN:");
        int userInputPin = scanner.nextInt();
        scanner.nextLine();
        for (Map.Entry<String, String> account : accounts.entrySet()) {
            if (account.getKey().equals(userInputCardNumber) && account.getValue().equals( userInputPin)) {
                areCredentialsValid = true;
                break;

            } else areCredentialsValid = false;
        }
        return areCredentialsValid;
    }

}
