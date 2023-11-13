package com.ecommerce.AuctionServices;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class AuctionTaskScheduler {

    @Async
    @Scheduled(fixedRate = 5000)
    public void checkForFinishedCatalog(){
        System.out.println("Hello");
    }

}