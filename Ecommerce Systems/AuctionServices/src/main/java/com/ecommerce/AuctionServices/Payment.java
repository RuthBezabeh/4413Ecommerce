package com.ecommerce.AuctionServices;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long paymentId;
    private Long userId;
    private Long itemId;
    private Float total;
    private String card_number;
    private String card_fname;
    private String card_lname;
    private String card_expire_date;
    private String security_code;
    private String userName;

    public Payment(){

    }
    public Payment(Payment payment) {
    }
    public Payment(Long userId, Long itemId, Float total, String card_number, String card_fname, String card_lname, String card_expire_date, String security_code, String userName) {
        this.userId = userId;
        this.itemId = itemId;
        this.total = total;
        this.card_number = card_number;
        this.card_fname = card_fname;
        this.card_lname = card_lname;
        this.card_expire_date = card_expire_date;
        this.security_code = security_code;
        this.userName = userName;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
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
