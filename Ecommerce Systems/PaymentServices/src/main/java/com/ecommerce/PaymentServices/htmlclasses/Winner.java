package com.ecommerce.PaymentServices.htmlclasses;

public class Winner {
    private String FirstName;
    private String LastName;

    private String StreetName;
    private int StreetNumber;
    private String City;
    private String Country;
    private String PostalCode;

    public Winner(String firstName, String lastName, String streetName, int streetNumber, String country, String city, String postalCode) {
        FirstName = firstName;
        LastName = lastName;
        StreetName = streetName;
        StreetNumber = streetNumber;
        City = city;
        Country = country;
        PostalCode = postalCode;
    }
    public Winner() {
        FirstName = "James";
        LastName = "Bond";
        StreetName = "Keele";
        StreetNumber = 007;
        City = "Toronto";
        Country = "Canada";
        PostalCode = "CIAMI6";
    }


    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }
    public String getStreetName() {
        return StreetName;
    }

    public void setStreetName(String streetName) {
        StreetName = streetName;
    }

    public int getStreetNumber() {
        return StreetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        StreetNumber = streetNumber;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(String postalCode) {
        PostalCode = postalCode;
    }

}
