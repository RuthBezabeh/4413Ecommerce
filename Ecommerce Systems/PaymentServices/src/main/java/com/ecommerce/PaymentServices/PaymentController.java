package com.ecommerce.PaymentServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("ecommerce/payment")
public class PaymentController {

    private final PaymentService paymentService;


    @Autowired
    public PaymentController(PaymentService paymentService){

        this.paymentService = paymentService;
    }
    // might need to be done by catalog and user instead
    @GetMapping(value = "/paymentform", produces = MediaType.TEXT_HTML_VALUE)
    public String getPaymentPage(@RequestParam Long userId, @RequestParam Long itemId, @RequestParam boolean expeditedShipping, Model model ) {
        //return user information and total cost = price + shipping
        // send request to database service for user info?

        return paymentService.getPaymentPage(userId, itemId, expeditedShipping, model);

    }

    @GetMapping("/{payment_id}")
    @ResponseBody
    public Payment getpayment(@PathVariable Long payment_id){

        return this.paymentService.getpayment(payment_id);
    }

    //
    @PostMapping(produces = MediaType.TEXT_HTML_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String processPayment(@RequestBody Payment payment, Model model){

        return this.paymentService.processPayment(payment, model);
    }

//        @GET
//        @Path("/{userId},{itemId}")
//        @Produces(MediaType.APPLICATION_JSON)
//        public Payment getPaymentInfo(@PathParam("userId") int userId) {
//
//            return BookDAO.update(isbn, Book);
//        }
//
//        @PUT
//        @Path("/{isbn}")
//        @Consumes(MediaType.APPLICATION_JSON)
//        @Produces(MediaType.APPLICATION_JSON)
//        public List<Book> updateBook(@PathParam("isbn") int isbn, Book Book) {
//
//            return BookDAO.update(isbn, Book);
//        }



}
