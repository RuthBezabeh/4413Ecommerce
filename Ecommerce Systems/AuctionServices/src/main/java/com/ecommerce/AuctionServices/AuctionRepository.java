package com.ecommerce.AuctionServices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;
import java.util.List;

@Repository
public interface AuctionRepository extends JpaRepository<Auction, Long> {

//    //allows us to get the auction based on auctiontype and catalogId
//    @Query("SELECT a from Auction a where a.auctionType = ?1 AND a.catalogId = ?2")
//    List<Auction> findByAuctionTypeAndCatalogId(String auctionType, Long catalogId);
//
//    //allows us to remove the auction based on auctiontype and catalogId
//    @Modifying
//    @Transactional
//    @Query("DELETE FROM Auction a WHERE a.auctionType = ?1 AND a.catalogId = ?2")
//    int deleteByAuction_IdAndCatalogId(Long Auction_id, Long catalogId);
}
