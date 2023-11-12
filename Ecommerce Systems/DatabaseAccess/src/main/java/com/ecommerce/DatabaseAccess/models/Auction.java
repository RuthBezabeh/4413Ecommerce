package com.ecommerce.DatabaseAccess.models;

import javax.persistence.*;
import java.util.Date;
import lombok.Data;

@Data
@Entity
@Table(name="Auction")
public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long Auction_id;
    private Long catalogId; //foreign key to same item in catalog
    private String itemname;
    private String auctionType;
    private Double startPrice;
    private Date end_date;
    private Double highestBid;
    private int highestBidder; //id, foreign key to user
    Auction(){}
    public Auction(Long catalogId, String itemname, String auctionType, Double startPrice, Date end_date, Double highestBid, int highestBidder) {
        this.catalogId = catalogId;
        this.itemname = itemname;
        this.auctionType = auctionType;
        this.startPrice = startPrice;
        this.end_date = end_date;
        this.highestBid = highestBid;
        this.highestBidder = highestBidder;
    }

    public Long getAuction_id() {
        return Auction_id;
    }

    public void setAuction_id(Long bid_id) {
        this.Auction_id = bid_id;
    }

    public Long getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Long catalogId) {
        this.catalogId = catalogId;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
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

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
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
