package com.ecommerce.AuctionServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;


@Service
public class AuctionService2 {

    private final AuctionRepository auctionRepository;
    private final PaymentRepository paymentRepository;
    private final CatalogRepository catalogRepository;
    private final UserRepository userRepository;

    private Catalog closestAuctions;

    @Autowired
    public AuctionService2(AuctionRepository auctionRepository, PaymentRepository paymentRepository, CatalogRepository catalogRepository, UserRepository userRepository) {
        this.auctionRepository = auctionRepository;
        this.paymentRepository = paymentRepository;
        this.catalogRepository = catalogRepository;
        this.userRepository = userRepository;
        this.closestAuctions = null;
    }

    public Auction createAuction(Auction auction) {
        return auctionRepository.save(auction);
    }

    public boolean createBid(Long auctionId, Long userId, Double bid) {
        //check to see if corresponding item exists
        Auction auction = auctionRepository.findById(auctionId).get();
        Long itemId = auction.getCatalogId();
        //item being bid for currently exists on cat table
        if (catalogRepository.getReferenceById(itemId) != null) {
            //Check bid type
            boolean failForward = false;
            String type = auction.getAuctionType();


        }
        return false;
    }
    public Auction forwardBid(Long id){
        return auctionRepository.findById(id).get();
    }
    public Auction DutchBid(Long id){
        return auctionRepository.findById(id).get();
    }
    public String auctionEnded(){
        return "sorry auction has ended";
    }


//    public Auction getAuctionBid(Long BidId) {
//        return auctionRepository.findById(BidId).get();
//    }
//
//    public List<Auction> getAllAuctionBids() {
//        return auctionRepository.findAll();
//    }


    @Async
    @Scheduled(fixedRate = 1000)
    public void performActionAndReplace() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        Date date = java.sql.Date.valueOf(currentDateTime.toLocalDate());
        Time time = java.sql.Time.valueOf(currentDateTime.toLocalTime());
        System.out.println("checking");
        //LocalDate nextEndDate = closestAuctions.getAuctionEndDate();

        if (this.closestAuctions == null ){
            this.closestAuctions = getClosestAuction();
            System.out.println("closestAuction first addition");
        }
        System.out.println(closestAuctions.getAuctionEndTime());
        if (this.closestAuctions != null && ( closestAuctions.getAuctionEndDate().equals(date)) && closestAuctions.getAuctionEndTime().before(time)) {

            catalogRepository.deleteById(closestAuctions.getItemId());
            System.out.println("item deleted");
            this.closestAuctions = getClosestAuction();
            System.out.println("closest auction replaced");
        }
//        if (this.closestAuctions != null && ((this.closestAuctions.getAuctionEndDate().after(date) || closestAuctions.getAuctionEndDate().equals(date)) && closestAuctions.getAuctionEndTime().after(time))) {
//
//            catalogRepository.deleteById(closestAuctions.getItemId());
//            System.out.println("item deleted");
//
//            this.closestAuctions = getClosestAuction();
//            System.out.println("closest auction replaced");
//        }

    }

    public Catalog getClosestAuction() {
        LocalDate currentdate = LocalDate.now();
        LocalTime currenttime = LocalTime.now();
        Date currentDate = Date.valueOf(currentdate);
        Time currentTime = Time.valueOf(currenttime);

        List<Catalog> ongoing  = catalogRepository.findClosestToEndDateTime(currentDate);
        boolean notfound = true;
        int i=0;
        while(notfound && i < ongoing.size()){
            System.out.print(ongoing.get(i).getAuctionEndDate());
            System.out.println(ongoing.get(i).getAuctionEndTime());

            if(ongoing.get(i).getAuctionEndTime().after(currentTime)){
                notfound = false;
                this.closestAuctions = ongoing.get(i);
            }
            if(ongoing.get(i).getAuctionEndTime().before(currentTime)){
                catalogRepository.deleteById(ongoing.get(i).getItemId());
            }
            i++;
        }

        if(this.closestAuctions != null){
            System.out.println(this.closestAuctions.getItem_name());
        } else System.out.println("no items on auction remaining");
        return this.closestAuctions;
    }
}


//    public Auction getAuctionBid(Long BidId){
//        return auctionRepository.findById(BidId).get();
//    }
//
//    public List<Auction> getAllAuctionBids() {
//        return auctionRepository.findAll();
//    }