package com.ecommerce.DatabaseAccess.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
@Repository
public interface AuctionRepository extends JpaRepository<Auction, Long> {

}

