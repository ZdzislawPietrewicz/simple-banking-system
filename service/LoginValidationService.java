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
