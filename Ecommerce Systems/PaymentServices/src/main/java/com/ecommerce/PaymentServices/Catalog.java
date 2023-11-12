package com.ecommerce.PaymentServices;

import lombok.Data;

import jakarta.persistence.*;
import java.sql.Time;
import java.util.Date;

@Data
@Entity
@Table(name="Catalog")
public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long item_id;
    private String item_name;


    private String seller_username;
    private String auction_type;

    public Float getShipping_price() {
        return shipping_price;
    }

    public void setShipping_price(Float shipping_price) {
        this.shipping_price = shipping_price;
    }

    public Float getExpedited_shipping() {
        return expedited_shipping;
    }

    public void setExpedited_shipping(Float expedited_shipping) {
        this.expedited_shipping = expedited_shipping;
    }

    private Float shipping_price;
    private Float expedited_shipping;

    private Time auction_duration;
    private String item_description;
    private String shipping_time; //need to clarify
    private Double initial_price;
    private Date auction_start_time;
    public Catalog(){}
    public Catalog(String item_name, String auction_type, String item_description, String shipping_time, Double initial_price, Time auction_start_time) {
        this.item_name = item_name;
        this.auction_type = auction_type;
        this.item_description = item_description;
        this.shipping_time = shipping_time;
        this.initial_price = initial_price;
        this.auction_start_time = auction_start_time;
    }

    public Long getItem_id() {
        return item_id;
    }

    public void setItem_id(Long item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getAuction_type() {
        return auction_type;
    }

    public void setAuction_type(String auction_type) {
        this.auction_type = auction_type;
    }

    public String getItem_description() {
        return item_description;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }

    public String getShipping_time() {
        return shipping_time;
    }

    public void setShipping_time(String shipping_time) {
        this.shipping_time = shipping_time;
    }

    public Double getInitial_price() {
        return initial_price;
    }

    public void setInitial_price(Double initial_price) {
        this.initial_price = initial_price;
    }

    public Date getEndTime() {
        return auction_start_time;
    }

    public void setEndTime(Time auction_start_time) {
        this.auction_start_time = auction_start_time;
    }

    public String getSeller_username() {
        return seller_username;
    }

    public void setSeller_username(String seller_username) {
        this.seller_username = seller_username;
    }

    public Date getAuction_start_time() {
        return auction_start_time;
    }


    public Time getAuction_duration() {
        return auction_duration;
    }

    public void setAuction_duration(Time auction_duration) {
        this.auction_duration = auction_duration;
    }

    public void setAuction_start_time(Date auction_start_time) {
        this.auction_start_time = auction_start_time;
    }
}
