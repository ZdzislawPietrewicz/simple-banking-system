package com.zdzislawpietrewicz.simplebankingsystem.data;

public class CreditCard {
    private String creditCardNumber;
    private String pin;
    private int balance;

    public CreditCard(String creditCardNumber, String pin, int balance) {
        this.creditCardNumber = creditCardNumber;
        this.pin = pin;
        this.balance = balance;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
