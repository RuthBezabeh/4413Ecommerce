package com.ecommerce.PaymentServices;

import com.ecommerce.PaymentServices.htmlclasses.ItemWon;
import com.ecommerce.PaymentServices.htmlclasses.Winner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PaymentService {
    //api call to user service for payment page user info

    private final PaymentRepository paymentRepository;
    private final AuctionRepository auctionRepository;
    private final CatalogRepository catalogRepository;
    private final UserRepository userRepository;

//    private final WebClient webClient;
//
//

    @Autowired
    public PaymentService( final PaymentRepository paymentRepository,final AuctionRepository auctionRepository,final CatalogRepository catalogRepository, final UserRepository userRepository){
        //this.webClient = webClientBuilder.baseUrl("https://localhost:5000/ecommerce").build();
        this.paymentRepository = paymentRepository;
        this.userRepository = userRepository;
        this.catalogRepository = catalogRepository;
        this.auctionRepository = auctionRepository;
        System.out.println("service created or rep");
    }

    public String getPaymentPage(Long userId,Long itemId, boolean expeditedShipping, Model model ) {

//
//        Double total = getTotalPrice(userId, itemId, expeditedShipping);
//        User user = userRepository.findByUserId(userId);
//        Catalog item = catalogRepository.findByItemId(itemId);
//        Winner winner1 = new Winner(user.getFirstname(), user.getLastname(), user.getStreet_name(), user.getStreet_number(), user.getCountry(), user.getCity(), user.getPostal_code(), total);
        Winner winner = new Winner();
        ItemWon itemwon = new ItemWon();

        model.addAttribute("winner", winner);
        model.addAttribute("itemwon", itemwon);
        return "paymentForm";

        //return ;
    }

    public Payment getpayment(Long payment_id){

        return paymentRepository.findByPaymentId(payment_id);
    }

    public Double getTotalPrice(Long user_id, Long item_id, boolean expedited){

        Double finalPrice = auctionRepository.findByCatalogId(item_id).getHighestBid();
        Float shipping = catalogRepository.findByItemId(item_id).getShipping_price();
        Float toatalShipping = shipping;
        if(expedited)
             toatalShipping += catalogRepository.findByItemId(item_id).getExpedited_shipping();

        return finalPrice + toatalShipping;

    }

    public String processPayment(@RequestBody Payment payment, Model model){
        paymentRepository.save(payment);

        Winner winner = new Winner();
        ItemWon itemwon = new ItemWon();

        model.addAttribute("winner", winner);
        model.addAttribute("itemwon", itemwon);
        return "reciept";
    }


}
