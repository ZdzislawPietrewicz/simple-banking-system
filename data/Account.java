import java.math.BigInteger;

public class Account {
    private int accountIdentifier;
    private int pin;
    private long creditCardNumber;


    public Account(int accountIdentifier, int pin, long creditCardNumber) {
        this.accountIdentifier = accountIdentifier;
        this.pin = pin;
        this.creditCardNumber = creditCardNumber;
    }

    Account(){
    }

    public int getAccountIdentifier() {
        return accountIdentifier;
    }

    public void setAccountIdentifier(int accountIdentifier) {
        this.accountIdentifier = accountIdentifier;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public long getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(long creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }
}
