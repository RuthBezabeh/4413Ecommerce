package com.ecommerce.AuctionServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "/ecommerce/auction")
public class AuctionController {

    private final AuctionService auctionService;

    @Autowired
    public AuctionController(AuctionService auctionService){
        this.auctionService = auctionService;
    }

    @PostMapping
    public boolean createAuctionBid(@RequestBody Auction auction){
        return auctionService.createAuctionBid(auction);
    }

    @GetMapping (path = "/{auctionId}")
    public Auction getAuctionBid(@PathVariable Long auctionId){
        return auctionService.getAuctionBid(auctionId);
    }

    @GetMapping List<Auction> getAllAuctionBids(){
        return auctionService.getAllAuctionBids();
    }


}
