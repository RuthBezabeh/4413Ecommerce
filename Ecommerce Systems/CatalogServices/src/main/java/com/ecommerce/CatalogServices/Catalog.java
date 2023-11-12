package com.ecommerce.CatalogServices;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Entity
public class Catalog {
    @Id
    @GeneratedValue
    private Long itemId;
    @Column
    private String itemName;
    @Column
    private String auctionType;
    @Column
    private String description;
    private String shippingTime; //need to clarify
    @Column
    private Double startPrice;
    private Date endDate;
    private int auctionDuration;
    public Catalog(){}
    public Catalog(String itemName, String auctionType, String description, String shippingTime, Double startPrice, Date endDate) {
        this.itemName = itemName;
        this.auctionType = auctionType;
        this.description = description;
        this.shippingTime = shippingTime;
        this.startPrice = startPrice;
        this.endDate = endDate;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getAuctionType() {
        return auctionType;
    }

    public void setAuctionType(String auctionType) {
        this.auctionType = auctionType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShippingTime() {
        return shippingTime;
    }

    public void setShippingTime(String shippingTime) {
        this.shippingTime = shippingTime;
    }

    public Double getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Double startPrice) {
        this.startPrice = startPrice;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public int getAuctionDuration() {
        return auctionDuration;
    }

    public void setAuctionDuration(int auctionDuration) {
        this.auctionDuration = auctionDuration;
    }

}
