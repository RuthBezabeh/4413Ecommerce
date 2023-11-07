package com.ecommerce.PaymentServices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    String pattern = "dd-MM-yyyy";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);


    @Bean
    CommandLineRunner initDatabase(PaymentRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Payment(1, "Bilbo Baggins", "1111222233334444",123, simpleDateFormat.parse("31-12-2030"))));
            log.info("Preloading " + repository.save(new Payment(2, "Frodo Baggins", "1111222233335555",123, simpleDateFormat.parse("31-12-2030"))));
        };
    }
}
