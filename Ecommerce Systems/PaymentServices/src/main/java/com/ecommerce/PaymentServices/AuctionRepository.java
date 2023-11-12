package com.ecommerce.PaymentServices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuctionRepository extends JpaRepository<Auction, Long> {
    Auction findByAuctionId(Long payment_id);
    Auction findByHighestBidder(Long userId);
    Auction findByCatalogId(Long item_id);

   Auction findByCatalogIdAndHighestBidder(Long item_id, Long userId);
}

