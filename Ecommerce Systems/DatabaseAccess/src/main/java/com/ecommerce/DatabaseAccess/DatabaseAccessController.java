package com.ecommerce.DatabaseAccess;

import org.springframework.web.bind.annotation.*;

@RestController
public class DatabaseAccessController {
    @GetMapping("/AuctionInfo/{auctionId}")
    public void getAuctionItem(){

    }

    @PostMapping("AuctionInfo/{auctionId}")
    public void createAuctionItem(){

    }

    @PutMapping("AuctionInfo/{auctionId}")
    public void updateAuctionItem(){

    }

    @DeleteMapping("AuctionInfo/{auctionId}")
    public void DeleteAuctionItem(){

    }

    @GetMapping("/CatalogInfo/{CatalogId}")
    public void getCatalogItem(){

    }

    @PostMapping("CatalogInfo/{CatalogId}")
    public void createCatalogItem(){

    }

    @PutMapping("CatalogInfo/{CatalogId}")
    public void updateCatalogItem(){

    }

    @DeleteMapping("CatalogInfo/{auctionId}")
    public void DeleteCatalogItem(){

    }

    @GetMapping("/UserInfo/{UserId}")
    public void getUserItem(){

    }

    @PostMapping("UserInfo/{UserId}")
    public void createUserItem(){

    }

    @PutMapping("UserInfo/{UserId}")
    public void updateUserItem(){

    }

    @DeleteMapping("UserInfo/{UserId}")
    public void DeleteUserItem(){

    }

    @GetMapping("/PaymentInfo/{paymentId}")
    public void getPaymentItem(@RequestParam int paymentId){


    }

    @PostMapping("AuctionInfo/{paymentId}")
    public void createPaymentItem(){

    }

    @PutMapping("PaymentInfo/{paymentId}")
    public void updatePaymentItem(){

    }

    @DeleteMapping("PaymentInfo/{paymentId}")
    public void DeletePaymentItem(){

    }
}
