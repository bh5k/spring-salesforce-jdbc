package com.pluralsight.springsalesforcejdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class SpringSalesforceJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSalesforceJdbcApplication.class, args);
	}

}
