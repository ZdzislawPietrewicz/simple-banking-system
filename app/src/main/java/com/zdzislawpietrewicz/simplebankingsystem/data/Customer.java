package com.zdzislawpietrewicz.simplebankingsystem.data;

public class Customer {
    private Account account;
    private Address address;

    public Customer(Account account, Address address) {
        this.account = account;
        this.address = address;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
