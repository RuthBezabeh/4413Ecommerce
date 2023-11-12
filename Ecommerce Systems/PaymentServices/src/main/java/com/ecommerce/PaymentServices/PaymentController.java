package com.ecommerce.PaymentServices;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ecommerce/payment")
public class PaymentController {

    private final PaymentService paymentService;


    @Autowired
    public PaymentController(PaymentService paymentService){

        this.paymentService = paymentService;
    }
    // might need to be done by catalog and user instead
    @GetMapping(path = "/Payment")
    public void getPaymentInfo(@RequestParam Long userId, @RequestParam long itemId, @RequestParam boolean expeditedShipping ) {
        //return user information and total cost = price + shipping
        // send request to database service for user info?
        //
        Double total = paymentService.getTotalPrice(userId, itemId, expeditedShipping);


        //return ;
    }

    //
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Payment processPayment(@RequestBody Payment payment){
        return this.paymentService.processPayment(payment);
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
