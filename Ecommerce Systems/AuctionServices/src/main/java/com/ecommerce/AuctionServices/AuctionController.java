package com.ecommerce.AuctionServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "/auction")
public class AuctionController {

    private final AuctionService auctionService;

    @Autowired
    public AuctionController(AuctionService auctionService){
        this.auctionService = auctionService;
    }

    @GetMapping (path = "/get/{bidId}")
    public Auction getAuctionBid(@PathVariable int bidId){
        return auctionService.getAuctionBid(bidId);
    }


}
