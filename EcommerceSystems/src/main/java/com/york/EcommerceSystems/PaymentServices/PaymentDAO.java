package com.york.EcommerceSystems.PaymentServices;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class PaymentDAO {


        private final WebClient webClient;
        private final PaymentRepository paymentRepository;
        private final AuctionRepository auctionRepository;
        private final CatalogRepository catalogRepository;
        private final UserRepository userRepository;

        @Autowired
        public PaymentDAO(WebClient.Builder webClientBuilder, PaymentRepository paymentRepository, AuctionRepository auctionRepository,CatalogRepository catalogRepository, UserRepository userRepository) {
            this.webClient = webClientBuilder.baseUrl("localhost:5000/ecommerce").build();
            this.paymentRepository = paymentRepository;
            this.userRepository = userRepository;
            this.catalogRepository = catalogRepository;
            this.auctionRepository = auctionRepository;
        }

        @Transactional
        public void fetchDataAndSaveToDatabase() {
            String endpoint = "/payment/1"; // Replace with the actual endpoint

            Mono<PaymentRequest> response = webClient.get()
                    .uri(endpoint)
                    .retrieve()
                    .bodyToMono(PaymentRequest.class);

            // Use subscribe or block to execute the WebClient call and handle the response
            response.subscribe(
                    data -> {
                        System.out.println("Received data " + data);
                        //return data;
                    },
                    error -> System.err.println("Error while fetching" + error.getMessage())
            );
        }


}
