package com.ecommerce.AuctionServices;


import jakarta.persistence.*;

@Entity
@Table
public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bidId;
    private int auctionedItemId;
    private double highestPrice;
    private String highestBidderName;
    @Transient
    private String auctionEndTime;

    public Auction() {

    }
    public Auction(int auctionedItemId, double highestPrice, String highestBidderName, String auctionEndTime) {
        this.auctionedItemId = auctionedItemId;
        this.highestPrice = highestPrice;
        this.highestBidderName = highestBidderName;
        this.auctionEndTime = auctionEndTime;
    }

    public int getBidId() {
        return bidId;
    }

    public void setBidId(int bidId) {
        this.bidId = bidId;
    }

    public int getAuctionedItemId() {
        return auctionedItemId;
    }

    public void setAuctionedItemId(int auctionedItemId) {
        this.auctionedItemId = auctionedItemId;
    }

    public double getHighestPrice() {
        return highestPrice;
    }

    public void setHighestPrice(double highestPrice) {
        this.highestPrice = highestPrice;
    }

    public String getHighestBidderName() {
        return highestBidderName;
    }

    public void setHighestBidderName(String highestBidderName) {
        this.highestBidderName = highestBidderName;
    }

    public String getAuctionEndTime() {
        return auctionEndTime;
    }

    public void setAuctionEndTime(String auctionEndTime) {
        this.auctionEndTime = auctionEndTime;
    }
}
