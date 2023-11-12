package com.ecommerce.DatabaseAccess.models;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="Payment")
public class Payment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long payment_id;
    private Long userId;
    private Long item_id;
    private Float total;
    private String card_number;
    private String card_fname;
    private String card_lname;
    private String card_expire_date;
    private String security_code;
    private String userName;

    public Long getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(Long payment_id) {
        this.payment_id = payment_id;
    }

    public Long getItem_id() {
        return item_id;
    }

    public void setItem_id(Long item_id) {
        this.item_id = item_id;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getCard_fname() {
        return card_fname;
    }

    public void setCard_fname(String card_fname) {
        this.card_fname = card_fname;
    }

    public String getCard_lname() {
        return card_lname;
    }

    public void setCard_lname(String card_lname) {
        this.card_lname = card_lname;
    }

    public String getCard_expire_date() {
        return card_expire_date;
    }

    public void setCard_expire_date(String card_expire_date) {
        this.card_expire_date = card_expire_date;
    }

    public String getSecurity_code() {
        return security_code;
    }

    public void setSecurity_code(String security_code) {
        this.security_code = security_code;
    }

    public Payment(Long userId, Long item_id, Float total, String card_number, String card_fname, String card_lname, String card_expire_date, String security_code, String userName) {
        this.userId = userId;
        this.item_id = item_id;
        this.total = total;
        this.card_number = card_number;
        this.card_fname = card_fname;
        this.card_lname = card_lname;
        this.card_expire_date = card_expire_date;
        this.security_code = security_code;
        this.userName = userName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }




}
