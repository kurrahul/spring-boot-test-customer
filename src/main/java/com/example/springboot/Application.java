package com.example.springboot;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.infy.model.Customer;
import com.infy.model.Gender;
import com.infy.model.Response;
import com.infy.model.Status;
import com.infy.service.CustomerService;
import com.infy.service.CustomerServiceImpl;

@SpringBootApplication
public class Application {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		Customer customer = new Customer("cu001", "Infyme", 18, "1234567890", "infy@infy.com", Gender.MALE,
				Status.active);
		CustomerService customerService = new CustomerServiceImpl();

		// check add customer
		Response<String> response = customerService.addCustomer(customer);
		logger.info("Lets see the response from Add customer:");
		for (String msg : response.getMessages()) {
			logger.info(msg);
		}
		logger.info("Added Customer: {}", response.getCustomer().toString());

		// check find customer
		response = customerService.findCustomer("cu001");
		logger.info("Lets see the response from find customer:");
		logger.info("response: {}", response.getMessages().get(0));
		if (response.getCustomer() != null) {
			logger.info("data: {}", response.getCustomer().toString());
		}

		// check update customer
		Customer customer1 = new Customer("cu001", "Infyme01", 21, "1234567890", "infy@infy.com", Gender.MALE,
				Status.active);
		response = customerService.updateCustomer(customer1);
		logger.info("Lets see the response from update customer:");
		logger.info("response: {}", response.getMessages().get(0));
		if (response.getCustomer() != null) {
			logger.info("data: {}", response.getCustomer().toString());
		}

		// check update customer
		response = customerService.deactivateCustomer(customer1);
		logger.info("Lets see the response from deactivate customer:");
		logger.info("response: {}", response.getMessages().get(0));
		if (response.getCustomer() != null) {
			logger.info("data: {}", response.getCustomer().toString());
		}

	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			// System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				// System.out.println(beanName);
			}

		};
	}

}
