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
		List<Automobile> autos = automobileService.findAll();
		assertNotNull(autos);
	}
}
