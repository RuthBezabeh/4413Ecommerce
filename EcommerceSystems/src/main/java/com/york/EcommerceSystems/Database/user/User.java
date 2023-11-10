package com.york.EcommerceSystems.Database.user;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class User {
    private @Id @GeneratedValue Long userId;
    private String firstName;
    private String LastName;
    private String streetAddress;
    private int streetNumber;
    private String postalCode;
    private String city;
    private String country;

    private String userName;
    private String password;
    public User (String username2, String password2, String shippingAddress){}
    public User(String firstName, String lastName, String streetAddress, int streetNumber, String postalCode, String city, String country, String userName, String password) {
        this.firstName = firstName;
        LastName = lastName;
        this.streetAddress = streetAddress;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
        this.userName = userName;
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long username2) {
        this.userId = username2;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
