package com.ecommerce.DatabaseAccess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.ecommerce.DatabaseAccess.models")
public class DatabaseAccessApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseAccessApplication.class, args);
	}

}
