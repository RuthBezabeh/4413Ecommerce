package com.york.EcommerceSystems;

import com.york.EcommerceSystems.Database.auction.AuctionItem;
import com.york.EcommerceSystems.Database.auction.AuctionItemRepository;
import com.york.EcommerceSystems.Database.catalog.Item;
import com.york.EcommerceSystems.Database.catalog.ItemRepository;
import com.york.EcommerceSystems.Database.payment.Payment;
import com.york.EcommerceSystems.Database.payment.PaymentRepository;
import com.york.EcommerceSystems.Database.user.User;
import com.york.EcommerceSystems.Database.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Date;
@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initUserDatabase(UserRepository repository1) {

        return args -> {
            log.info("Preloading " + repository1.save(new User("Bilbo", "Baggins", "Keele", 111, "ABCABC", "Toronto", "Canada", "Bilbo", "password")));
            log.info("Preloading " + repository1.save(new User("Frodo", "Baggins", "Keele", 111, "ABCABC", "Toronto", "Canada", "Bilbo", "password")));
        };
    }






        @Bean
        CommandLineRunner initItemDatabase( ItemRepository repository2)
        {

            return args -> {
                log.info("Preloading " + repository2.save(new Item("watch", "Forward", "great", "10 days", 20.0, new Date())));
                log.info("Preloading " + repository2.save(new Item("Bike", "Dutch", "great", "5 days", 30.0, new Date())));

            };
        }

            @Bean
            CommandLineRunner initAuctionDatabase(AuctionItemRepository repository3) {

                return args -> {
                    log.info("Preloading " + repository3.save(new AuctionItem(1L, "watch", "Forward", 20.0, new Date(),20.0, 1)));
                    log.info("Preloading " + repository3.save(new AuctionItem(1L, "bike", "Dutch", 30.0, new Date(),35.0, 1)));

                };
            }

    @Bean
    CommandLineRunner initPaymentDatabase(PaymentRepository repository4) {

        return args -> {
            log.info("Preloading " + repository4.save(new Payment("Bilbo", "Baggins", "Keele", 111, "ABCABC","Toronto", "Canada", "Bilbo", "password")));
            log.info("Preloading " + repository4.save(new Payment("Frodo", "Baggins", "Keele", 111, "ABCABC","Toronto", "Canada", "Bilbo", "password")));

        };
    }
}