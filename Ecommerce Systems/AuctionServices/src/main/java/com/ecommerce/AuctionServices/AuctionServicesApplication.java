package com.ecommerce.AuctionServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class AuctionServicesApplication {
	public static void main(String[] args) {
		SpringApplication.run(AuctionServicesApplication.class, args);
	}



//	//peforms the query for obtaining the selling user
//	@Query("SELECT u.username from user u WHERE u.username = ?1")
//	List<String> getSellerByUserName(String seller);
//
////    @Modifying
////    @Transactional
////    @Query("DELETE FROM Catalog c WHERE c.auction_end_date = ?1 AND c.auction_end_time <= ?2")
////    void deleteFinishedCatalog(LocalDate auction_end_date, LocalTime auction_end_time);
}
