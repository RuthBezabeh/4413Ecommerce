package com.ecommerce.AuctionServices;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

@Entity
@Table(name="Catalog")
public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;
    private String item_name;
    private String seller_username;
    private String auction_type;
    private Float shipping_price;
    private Float expedited_shipping;
    private LocalTime auction_duration;
    private Time auctionEndTime;
    private Date auctionEndDate;



    private Time auctionStartTime;
    private Date auctionStartDate;
    private String item_description;
    private String shipping_time; //need to clarify
    private Float initial_price;

    public Catalog() {
    }



    public Catalog(Long itemId, String item_name, String seller_username, String auction_type, Float shipping_price, Float expedited_shipping, LocalTime auction_duration, Time auctionEndTime, Date auctionEndDate, String item_description, String shipping_time, Float initial_price) {
        this.itemId = itemId;
        this.item_name = item_name;
        this.seller_username = seller_username;
        this.auction_type = auction_type;
        this.shipping_price = shipping_price;
        this.expedited_shipping = expedited_shipping;
        this.auction_duration = auction_duration;
        this.auctionEndTime = auctionEndTime;
        this.auctionEndDate = auctionEndDate;
        this.item_description = item_description;
        this.shipping_time = shipping_time;
        this.initial_price = initial_price;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getSeller_username() {
        return seller_username;
    }

    public void setSeller_username(String seller_username) {
        this.seller_username = seller_username;
    }

    public String getAuction_type() {
        return auction_type;
    }

    public void setAuction_type(String auction_type) {
        this.auction_type = auction_type;
    }

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

    public LocalTime getAuction_duration() {
        return auction_duration;
    }

    public void setAuction_duration(LocalTime auction_duration) {
        this.auction_duration = auction_duration;
    }
    public Time getAuctionStartTime() {
        return auctionStartTime;
    }

    public void setAuctionStartTime(Time auctionStartTime) {
        this.auctionStartTime = auctionStartTime;
    }

    public Date getAuctionStartDate() {
        return auctionStartDate;
    }

    public void setAuctionStartDate(Date auctionStartDate) {
        this.auctionStartDate = auctionStartDate;
    }

    public Time getAuctionEndTime() {
        return auctionEndTime;
    }

    public void setAuctionEndTime(Time auctionEndTime) {
        this.auctionEndTime = auctionEndTime;
    }

    public Date getAuctionEndDate() {
        return auctionEndDate;
    }

    public void setAuctionEndDate(Date auctionEndDate) {
        this.auctionEndDate = auctionEndDate;
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

    public Float getInitial_price() {
        return initial_price;
    }

    public void setInitial_price(Float initial_price) {
        this.initial_price = initial_price;
    }
}