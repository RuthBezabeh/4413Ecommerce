package com.york.EcommerceSystems.Database.catalog;
import java.util.Date;
import java.util.Objects;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Item {
    private @Id @GeneratedValue Long itemId;
    private String itemName;
    private String auctionType;
    private String description;
    private String shippingTime; //need to clarify
    private Double startPrice;
    private Date endDate;
    Item(){}
    public Item(String itemName, String auctionType, String description, String shippingTime, Double startPrice, Date endDate) {
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
}
