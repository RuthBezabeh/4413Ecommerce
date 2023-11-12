package com.ecommerce.AuctionServices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public interface AuctionRepository extends JpaRepository<Auction, Integer> {
}
