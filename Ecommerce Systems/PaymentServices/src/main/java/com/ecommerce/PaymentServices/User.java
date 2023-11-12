package com.ecommerce.PaymentServices;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name="User")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private  Long userId;
    private String firstname;
    private String lastname;
    private String street_name;
    private int street_number;
    private String postal_code;
    private String city;
    private String country;

    private String username;
    private String password;
    public User (String username2, String password2, String shippingAddress){}
    public User(String firstName, String lastname, String street_name, int street_number, String postal_code, String city, String country, String username, String password) {
        this.firstname = firstName;
        this.lastname = lastname;
        this.street_name = street_name;
        this.street_number = street_number;
        this.postal_code = postal_code;
        this.city = city;
        this.country = country;
        this.username = username;
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long username2) {
        this.userId = username2;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStreet_name() {
        return street_name;
    }

    public void setStreet_name(String street_name) {
        this.street_name = street_name;
    }

    public int getStreet_number() {
        return street_number;
    }

    public void setStreet_number(int street_number) {
        this.street_number = street_number;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
