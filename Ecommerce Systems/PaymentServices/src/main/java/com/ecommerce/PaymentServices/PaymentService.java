package com.ecommerce.PaymentServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class PaymentService {
    //api call to user service for payment page user info

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(final PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
        System.out.println("service created or rep");
    }
    public Double getTotalPrice(Long user_id, Long item_id, boolean expidited){
//        Float finalPrice = getAuctionPrice(item_id);
//        Float shipping = getCatalogShippingPrice(item_id);
//        Float toatalShipping = shipping;
//        if(expidited)
//             toatalShipping += getCatalogExpeditedShipping(item_id);
//
//        return finalPrice + toatalShipping;

        return 0.0;
    }

    public Payment processPayment(@RequestBody Payment payment){
        return paymentRepository.save(payment);

    }


}
