package com.pluralsight.springsalesforcejdbc;

import com.pluralsight.springsalesforcejdbc.model.Automobile;
import com.pluralsight.springsalesforcejdbc.service.AutomobileService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SpringSalesforceJdbcApplicationTests {

	@Autowired
	AutomobileService automobileService;

	@Test
	void testJdbc() {
		Long time = System.currentTimeMillis();
		System.out.println("Before first:" + time);
		List<Automobile> autos = automobileService.findAll();
		assertNotNull(autos);
		System.out.println("Elapsed:" + (System.currentTimeMillis() - time));
	}

	@Test
	void testJdbcCached() {
		Long time = System.currentTimeMillis();
		System.out.println("Before second:" + time);
		List<Automobile> autos = automobileService.findAll();
		assertNotNull(autos);
		System.out.println("Elapsed:" + (System.currentTimeMillis() - time));
	}
}
