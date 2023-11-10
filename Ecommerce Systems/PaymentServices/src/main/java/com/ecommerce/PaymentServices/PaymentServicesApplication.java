package com.ecommerce.PaymentServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.reactive.function.client.WebClient;
@SpringBootApplication
public class PaymentServicesApplication {

	public static void main(String[] args) {

		SpringApplication.run(PaymentServicesApplication.class, args);

		String databaseUrl = "https://localhost:6000/DatabaseServices";
		//WebClient.Builder builder = WebClient.builder()
	}

}
