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
    public Auction createAuction(@RequestBody Auction auction){
        return auctionService.createAuction(auction);
    }


    @PostMapping(path = "/bid/{auctionId}")
    public boolean createBid(@PathVariable Long auctionId, @RequestParam Double bid, @RequestParam Long userId){
        return auctionService.createBid(auctionId,userId, bid);
    }

    @GetMapping (path = "/{auctionId}")
    public Auction getAuctionBid(@PathVariable Long auctionId){
        return auctionService.getAuctionBid(auctionId);
    }

    @GetMapping List<Auction> getAllAuctionBids(){
        return auctionService.getAllAuctionBids();
    }


}
