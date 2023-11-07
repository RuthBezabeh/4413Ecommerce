package com.ecommerce.PaymentServices;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


import java.util.Date;
@Entity
public class Payment {
    private @Id @GeneratedValue int id;
    private int userId;
    private String name;
    private String cardNumber;
    private int securityCode;
    private Date expireDate;

    Payment(){}

    public Payment(int userId, String name, String cardNumber, int securityCode, Date expireDate) {
        this.userId = userId;
        this.name = name;
        this.cardNumber = cardNumber;
        this.securityCode = securityCode;
        this.expireDate = expireDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(int securityCode) {
        this.securityCode = securityCode;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }
}
