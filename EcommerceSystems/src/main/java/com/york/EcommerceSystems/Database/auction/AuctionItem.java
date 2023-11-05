package com.york.EcommerceSystems.Database.auction;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AuctionItem {
    private @Id @GeneratedValue Long id;
    private Long catalogId; //foreign key to same item in catalog
    private String itemName;
    private String auctionType;
    private Double startPrice;
    private Date endDate;
    private Double highestBid;
    private int highestBidder; //id, foreign key to user
    AuctionItem(){}
    public AuctionItem(Long catalogId, String itemName, String auctionType, Double startPrice, Date endDate, Double highestBid, int highestBidder) {
        this.catalogId = catalogId;
        this.itemName = itemName;
        this.auctionType = auctionType;
        this.startPrice = startPrice;
        this.endDate = endDate;
        this.highestBid = highestBid;
        this.highestBidder = highestBidder;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Long catalogId) {
        this.catalogId = catalogId;
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

    public Double getHighestBid() {
        return highestBid;
    }

    public void setHighestBid(Double highestBid) {
        this.highestBid = highestBid;
    }

    public int getHighestBidder() {
        return highestBidder;
    }

    public void setHighestBidder(int highestBidder) {
        this.highestBidder = highestBidder;
    }
}
