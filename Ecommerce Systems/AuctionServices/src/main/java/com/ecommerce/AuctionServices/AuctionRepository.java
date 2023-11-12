package com.ecommerce.AuctionServices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public interface AuctionRepository extends JpaRepository<Auction, Integer> {

    public default Auction getAuctionBid(int BidId) {
        String sql = "SELECT * FROM auction WHERE bid_id = ?";
        try (Connection conn = DriverManager.getConnection("//ecommercedb.c25xj0lpmeiu.us-east-2.rds.amazonaws.com:3306/ecommercedb", "admin", "EECS4413!");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            int queryVal = BidId;
            pstmt.setInt(1, queryVal);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Auction auction = new Auction();
                    // Assuming you have a constructor or setters to initialize your Auction object
                    auction.setBidId(rs.getInt("bidId"));
                    // Set other fields of auction object from rs
                    return auction;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
