package com.ecommerce.UserServices;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "app_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String shippingAddress;

    // Getters
    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getShippingAddress() {
        return this.shippingAddress;
    }

    // Setters (if needed)
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public boolean validatePassword(String password) {
        return this.password.equals(password);
    }
}
