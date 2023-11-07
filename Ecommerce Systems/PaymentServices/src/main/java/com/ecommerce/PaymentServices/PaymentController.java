package com.ecommerce.PaymentServices;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    private final PaymentRepository repository;

    PaymentController(PaymentRepository repository){
        this.repository = repository;
    }

    //@GetMapping("/Payment/{userId},{itemId}")

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
