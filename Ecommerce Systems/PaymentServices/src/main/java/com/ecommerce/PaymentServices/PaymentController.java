package com.ecommerce.PaymentServices;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController {

    private PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }
    // might need to be done by catalog and user instead
    @GetMapping("/Payment/")
    public void getPaymentInfo(@RequestParam int userId, @RequestParam int itemId, @RequestParam boolean expeditedShipping ) {
        //return user information and total cost = price + shipping
        // send request to database service for user info?
        //


        //return ;
    }

    //
    @PostMapping("/Payment/{userId},{itemid}")
    public String processPayment(@PathParam("userId") int userId){

        return "";
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
