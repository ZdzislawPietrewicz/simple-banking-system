import java.util.Random;

public class AccountService {
    
    private static Account createAnAccount(int accountIdentifier) {
        final int BANK_IDENTIFICATION_NUMBER = 400000;
        final int INITIAL_BALANCE=0;
        System.out.println("");
        long creditCardNumberWithoutCheckDigit = Long.valueOf(String.valueOf(BANK_IDENTIFICATION_NUMBER) + String.valueOf(accountIdentifier));
        int creditCardCheckDigit = createCreditCardNumber(creditCardNumberWithoutCheckDigit);
        String creditCardNumberWithCheckDigit = String.valueOf(creditCardNumberWithoutCheckDigit * 10 + creditCardCheckDigit);
        CreditCard newCreditCard = new CreditCard(creditCardNumberWithCheckDigit, createPin(),INITIAL_BALANCE);
        Account account = new Account();
        account.setAccountIdentifier(accountIdentifier);
        account.setPin(createPin());
        account.setCreditCardNumber(creditCardNumberWithCheckDigit);
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
        return random.nextInt(9999) + 1;
    }

    private static int createCreditCardNumber(long customerCreditCardNumber) {
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
