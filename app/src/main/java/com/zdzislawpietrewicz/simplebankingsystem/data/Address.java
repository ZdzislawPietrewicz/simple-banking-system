package com.zdzislawpietrewicz.simplebankingsystem.data;

public class Address {
    private String street;
    private int homeNumber;
    private String additional;
    private String postalCode;
    private String country;

    public Address(String street, int homeNumber, String additional, String postalCode, String country) {
        this.street = street;
        this.homeNumber = homeNumber;
        this.additional = additional;
        this.postalCode = postalCode;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(int homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getAdditional() {
        return additional;
    }

    public void setAdditional(String additional) {
        this.additional = additional;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
