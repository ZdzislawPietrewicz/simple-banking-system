package com.zdzislawpietrewicz.simplebankingsystem.data;

public class Account {
    private int accountIdentifier;
    private CreditCard creditCard;


    public Account(int accountIdentifier, CreditCard creditCard) {
        this.accountIdentifier = accountIdentifier;
        this.creditCard = creditCard;
    }

    public int getAccountIdentifier() {
        return accountIdentifier;
    }

    public void setAccountIdentifier(int accountIdentifier) {
        this.accountIdentifier = accountIdentifier;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }
}
