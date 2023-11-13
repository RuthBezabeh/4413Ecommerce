package com.ecommerce.AuctionServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuctionService {

    private final AuctionRepository auctionRepository;

    @Autowired
    public AuctionService(AuctionRepository auctionRepository){
        this.auctionRepository = auctionRepository;
    }

    public boolean createAuctionBid(Auction auction) {
//       //Step 1. Check that time for that auction has not run out yet, so bid for that auction can be placed
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
