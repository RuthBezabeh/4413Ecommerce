package com.ecommerce.AuctionServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AuctionService {

    private final AuctionRepository auctionRepository;
    private final PaymentRepository paymentRepository;
    private final CatalogRepository catalogRepository;
    private final UserRepository userRepository;

    @Autowired
    public AuctionService(AuctionRepository auctionRepository, PaymentRepository paymentRepository, CatalogRepository catalogRepository, UserRepository userRepository){
        this.auctionRepository = auctionRepository;
        this.paymentRepository = paymentRepository;
        this.catalogRepository = catalogRepository;
        this.userRepository = userRepository;
    }

    public boolean createAuctionBid(Auction auction) {
//        //Step 1. Check that the item is on the catalog; still on auction so not bought or time has not run out.
//        Long item_id = auction.getCatalogId();
//
//        //Check 1: Check Time first, as scheduler may not have removed it yet
//        auctionRepository.findFromCatalog
//








//       //Step 2. Check if the item_id exists in catlogue
//
//        //    public void checkForFinishedCatalog(){
////        System.out.println("Hello");
////        //catalogRepo.deleteFinishedCatalog(LocalDate.now(), LocalTime.noFw());
////    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//        String auctionType = auction.getAuctionType();
//        boolean isWord = checkIsValidWord(auctionType);
//        //string for auction type is a word
//        if(isWord){
//            //checks if auctionType is Forward or Dutch; valid
//            if(checkIsValidAuctionType(auctionType)){
//                //forward checks current bid is > than current highest bid for the same item
//                if(auctionType.equals("Forward")){
//                    boolean isHighest = true;
//                    List<Auction> forwardAndCatalogIdAuctions =
//                            auctionRepository.findByAuctionTypeAndCatalogId("Forward", auction.getCatalogId());
//
//                    //Compares all bids to see if the input auction obj. has the highest
//                    for(Auction a: forwardAndCatalogIdAuctions){
//                        if(a.getHighestBid() >= auction.getHighestBid()){
//                            //Print error message
//                            isHighest = false;
//                        }
//                    }
//                    //the input auction obj. is the highest forward bid; add this and delete all others
//                    if(isHighest){
//                        //deletes all auctions that are not the highest (not valid)
//                        for(Auction a: forwardAndCatalogIdAuctions){
//                            auctionRepository.deleteByAuction_IdAndCatalogId(a.getAuction_id(), a.getCatalogId());
//                        }
//                        //inserts the auction to the auction table in db
//                        auctionRepository.save(auction);
//                    }
//                    else{
//                        //not the highest - need to inform them that the current bid is not the highest
//                        return false;
//                    }
//                }
//                //Dutch Auction
//                else if(auctionType.equals("Dutch")){
//
//                }
//            }
//        }
//        //string for auction type is not a word
//        else{
//            return false;
//        }
        return false;
    }

    @Async
    @Scheduled(fixedRate = 1000)
    public void checkForFinishedCatalog(){
        List<Auction> allBids = auctionRepository.findAll();
        List<Long> allItemIds = new ArrayList<Long>();
        for(int i = 0; i<allBids.size(); i++){
            allItemIds.add(allItemIds);
        }


    }

    public Auction getAuctionBid(Long BidId){
        return auctionRepository.findById(BidId).get();
    }

    public List<Auction> getAllAuctionBids() {
        return auctionRepository.findAll();
    }

    //Helper method to check if string is a word.
    private boolean checkIsValidWord(String value) {
        //is a non-null, non-empty, letter only string
        if(value != null && !value.isEmpty() && !value.isBlank()) {
            //goes through entire string, char by char
            for (char ch : value.toCharArray()) {
                //checks if each character is not a letter
                //returns false if any are
                if (!Character.isLetter(ch)) {
                    return false;
                }
            }
            return true;
        }
        else{
            return false;
        }
    }
    //Helper method to check if auction type is forward or dutch.
    private boolean checkIsValidAuctionType(String auctionType) {
        //valid
        if(auctionType.equals("Forward") || auctionType.equals("Dutch")){
            return true;
        }
        else{
            return false;
        }
    }
}
