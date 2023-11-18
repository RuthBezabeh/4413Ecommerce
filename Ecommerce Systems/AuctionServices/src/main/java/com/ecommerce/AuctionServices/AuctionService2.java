package com.ecommerce.AuctionServices;

import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
//<<<<<<< Updated upstream
import java.util.concurrent.CountDownLatch;
//=======
import java.util.concurrent.CompletableFuture;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;
//>>>>>>> Stashed changes

@Service
public class AuctionService {

    private final AuctionRepository auctionRepository;
    private final PaymentRepository paymentRepository;
    private final CatalogRepository catalogRepository;
    private final UserRepository userRepository;
//    private static double maxRate = 1.5;
//    private static final double minRate = 0.125;
//    private static double maxPrice;
//    private static double minPrice;
//    private final double dutchDecrementerRate = 0.0125;

    private Catalog closestAuctions;

    @Autowired
    public AuctionService(AuctionRepository auctionRepository, PaymentRepository paymentRepository, CatalogRepository catalogRepository, UserRepository userRepository) {
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

            if (type != null && type.equals("Forward")) {
                //Check to see if bid provided is valid; greater than all other bids for that item
                List<Auction> auctions = auctionRepository.findAll();
                for (int i = 0; i < auctions.size(); i++) {
                    if (itemId == auctions.get(i).getCatalogId()) {
                        if (bid.doubleValue() <= auctions.get(i).getHighestBid()) {
                            failForward = true;
                        }
                    }
                }
                if (!failForward) {
                    Auction reference = auctionRepository.getReferenceById(itemId);
                    Auction result = new Auction();
                    result.setCatalogId(reference.getCatalogId());
                    result.setItemname(reference.getItemname());
                    result.setAuctionType(reference.getAuctionType());
                    result.setEnd_date(reference.getEnd_date());
                    result.setHighestBid(bid.doubleValue());
                    result.setHighestBidder(userId.intValue());
                    result.setStartPrice(reference.getStartPrice());
                    auctionRepository.save(result);
                    return true;
                } else {
                    return false;
                }
            } else if (type != null & type.equals("Dutch")) {
                //Dutch is succesful
                //Get maxForItem being Dutch auctioned
//                maxPrice = auctionRepository.findById(auctionId).get().getStartPrice() * maxRate;
//                minPrice = auctionRepository.findById(auctionId).get().getStartPrice() * minRate;

//<<<<<<< Updated upstream
                if (bid <= auctionRepository.findById(auctionId).get().getStartPrice() &&
                        bid > 0) {
                    Auction reference = auctionRepository.getReferenceById(itemId);
                    Auction result = new Auction();
                    result.setCatalogId(reference.getCatalogId());
                    result.setItemname(reference.getItemname());
                    result.setAuctionType(reference.getAuctionType());
                    result.setEnd_date(reference.getEnd_date());
                    result.setHighestBid(bid.doubleValue());
                    result.setHighestBidder(userId.intValue());
                    result.setStartPrice(reference.getStartPrice());
                    auctionRepository.save(result);
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    //removes catalog items once expired
//    @Async
//    @Scheduled(fixedRate = 1000)
//    public void checkForFinishedCatalog(){
//        List <Catalog> catItems = catalogRepository.findAll();
//        for(int i = 0; i < catItems.size(); i++){
//            if (catItems.get(i).getAuction_end_time() == LocalTime.now() &&
//            catItems.get(i).getAuction_end_date() == LocalDate.now()){
//                catalogRepository.deleteById(catItems.get(i).getItemId());
//            }
//        }
//    }

//    @Async
//    @Scheduled(fixedRate = 10000)
//    public void checkForFinishedCatalogDutch(){
//        List <Auction> aItems = auctionRepository.findAll();
//        for(int i=0; i<aItems.size(); i++){
//            if(aItems.get(i).getAuctionType()!=null &&
//            aItems.get(i).getAuctionType().equals("Dutch")){
//                if(aItems.get(i).getStartPrice() > maxPrice){
//                    catalogRepository.deleteById(aItems.get(i).getCatalogId());
//                }
//            }
//        }
//    }

//    //Decrement
//    @Async
//    @Scheduled(fixedRate = 5000)
//    public void decrementMaxForDutch(){
//        //descrease the maxRate multiplier every 5 seconds
//        maxRate -= minRate;
//        if(maxPrice <= minPrice){
//            maxRate = 1.5;
//        }
//    }

    public Auction getAuctionBid(Long BidId) {
        return auctionRepository.findById(BidId).get();
    }

    public List<Auction> getAllAuctionBids() {
        return auctionRepository.findAll();
    }

//    //Helper method to check if string is a word.
//    private boolean checkIsValidWord(String value) {
//        //is a non-null, non-empty, letter only string
//        if(value != null && !value.isEmpty() && !value.isBlank()) {
//            //goes through entire string, char by char
//            for (char ch : value.toCharArray()) {
//                //checks if each character is not a letter
//                //returns false if any are
//                if (!Character.isLetter(ch)) {
//                    return false;
//                }
//            }
//            return true;
//        }
//        else{
//            return false;
//        }
//    }
//
//    //Helper method to check if auction type is forward or dutch.
//    private boolean checkIsValidAuctionType(String auctionType) {
//        //valid
//        if(auctionType.equals("Forward") || auctionType.equals("Dutch")){
//            return true;
//        }
//        else{
//            return false;
//        }
//    }
//}
}
//
//        //Check 1: Check Time first, as scheduler may not have removed it yet
//        auctionRepository.findFromCatalog
//
//=======
//>>>>>>> Stashed changes
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
//<<<<<<< Updated upstream
//=======
//        return false;
//    }
@Async
@Scheduled(fixedRate = 1000)
public void performActionAndReplace() {
    LocalDateTime currentDateTime = LocalDateTime.now();
    System.out.println("checking");
    if(closestAuctions == null || (closestAuctions.getAuction_end_date().isAfter(currentDateTime.toLocalDate()) && closestAuctions.getAuction_end_time().isAfter(currentDateTime.toLocalTime()))){
        closestAuctions = getClosestAuction();
        System.out.println("got closest date");

        if(closestAuctions != null){
            catalogRepository.deleteById(closestAuctions.getItemId());
            System.out.println("item deleted");
        }
    }

}

    public Catalog getClosestAuction() {
        LocalDate currentdate = LocalDate.now();
        LocalTime currenttime = LocalTime.now();
        Date currentDate = Date.valueOf(currentdate);
        Time currentTime = Time.valueOf(currenttime);

        closestAuctions = catalogRepository.findClosestToEndDateTime(currentDate, currentTime);
        System.out.println(closestAuctions.getItem_name());
        return closestAuctions;
    }

//
//    @Async
//    @Scheduled(fixedRate = 1000)
//    public void checkForFinishedCatalog(){
//        List<Auction> allAuctions = auctionRepository.findAll();
//        List<Long> allCatalogIds = new ArrayList<Long>();
//        Set<Long> setOfCatalogIds = new HashSet<>();
//
//        for(int i = 0; i<allAuctions.size(); i++){
//            allCatalogIds.add(i, allAuctions.get(i).getCatalogId());
//        }
//        setOfCatalogIds.addAll(allCatalogIds);
//        List<Catalog> catItems = new ArrayList<>();
//        for(int i = 0; i<setOfCatalogIds.toArray().length; i++){
//            catItems.add(i, catalogRepository.findById(allCatalogIds.get(i)).get());
//        }
//        for(int i = 0; i<catItems.size(); i++){
//            if(LocalTime.now().isAfter(catItems.get(i).getAuction_end_time())
//            && (LocalDate.now().isEqual(catItems.get(i).getAuction_end_date()) || LocalDate.now().isAfter(catItems.get(i).getAuction_end_date()))){
//                catalogRepository.deleteById(catItems.get(i).getItemId());
//            }
//
//        }
//        System.out.print("Hello");
//
//
//    }

    public Auction getAuctionBid(Long BidId){
        return auctionRepository.findById(BidId).get();
    }

    public List<Auction> getAllAuctionBids() {
        return auctionRepository.findAll();
    }
//>>>>>>> Stashed changes

//    List<Auction> allAuctions = auctionRepository.findAll();
//    List<Long> allCatalogIds = new ArrayList<Long>();
//    Set<Long> setOfCatalogIds = new HashSet<>();
//
//        for(int i = 0; i<allAuctions.size(); i++){
//        allCatalogIds.add(i, allAuctions.get(i).getCatalogId());
//        }
//        setOfCatalogIds.addAll(allCatalogIds);
//        List<Catalog> catItems = new ArrayList<>();
//        for(int i = 0; i<setOfCatalogIds.toArray().length; i++){
//        catItems.add(i, catalogRepository.findById(allCatalogIds.get(i)).get());
//        }
//        for(int i = 0; i<catItems.size(); i++){
//        if(LocalTime.now().isAfter(catItems.get(i).getAuction_end_time())
//        && (LocalDate.now().isEqual(catItems.get(i).getAuction_end_date()) || LocalDate.now().isAfter(catItems.get(i).getAuction_end_date()))){
//        catalogRepository.deleteById(catItems.get(i).getItemId());
//        }
//        }
//        System.out.print("Hello");