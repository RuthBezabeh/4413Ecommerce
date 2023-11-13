package com.ecommerce.PaymentServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
//
//
//    public Mono<PaymentResponse> getPaymentFromDb(Long id) {
//        return webClient.get()
//                .uri("payment/1")
//                .accept(MediaType.APPLICATION_JSON)
//                .retrieve()
//                .bodyToMono(PaymentResponse.class);
//    }
    public String getPaymentPage(Long userId,Long itemId, boolean expeditedShipping ) {
        //return user information and total cost = price + shipping
        // send request to database service for user info?

//        Double total = getTotalPrice(userId, itemId, expeditedShipping);
//        User user = userRepository.findByUserId(userId);
//        Catalog item = catalogRepository.findByItemId(itemId);

//        List<FieldDefinition> dynamicFields = Arrays.asList(
//                new FieldDefinition("Item", "Amount", FieldType.FLOAT),
//                new FieldDefinition("quantity", "Quantity", FieldType.INT)
//                // Add more fields as needed
//        );
//        // Pass dynamic fields to the view
//        model.addAttribute("dynamicFields", dynamicFields);
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

    public Payment processPayment(@RequestBody Payment payment){
        return paymentRepository.save(payment);

    }


}
