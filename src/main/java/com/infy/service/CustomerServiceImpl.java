package com.infy.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.infy.model.Customer;
import com.infy.model.Gender;
import com.infy.model.Response;
import com.infy.model.Status;
import com.infy.util.CustomerValidator;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Override
	public Response<String> addCustomer(Customer customer) {
		Response<String> response = new Response<String>();
		List<String> msgs = CustomerValidator.validateForAdd(customer);
		if (msgs != null && !msgs.isEmpty()) {
			response.setMessages(msgs);
			response.setCustomer(customer);
		} else {
			// Returning mocked msg to add a new customer
			List<String> msg = Arrays.asList("Customer added successfully.");
			response.setMessages(msg);
			response.setCustomer(customer);
		}
		return response;
	}

	@Override
	public Response<String> findCustomer(String id) {

		Response<String> response = new Response<String>();

		// Forming data
		List<Customer> customers = new ArrayList<Customer>();
		Customer customer1 = new Customer("cu001", "customer01", 18, "1234567890", "infy@infy.com", Gender.MALE,
				Status.active);
		Customer customer2 = new Customer("cu002", "customer02", 19, "1234567899", "infy1@infy.com", Gender.FEMALE,
				Status.active);
		customers.add(customer1);
		customers.add(customer2);

		boolean customerFound = false;
		for (Customer customer : customers) {
			if (customer.getId().equals(id)) {
				customerFound = true;
				response.setCustomer(customer);
			}
		}

		if (customerFound) {
			response.setMessages(Arrays.asList("Customer Found for ID:" + id));
		} else {
			response.setMessages(Arrays.asList("Customer Not Found for ID:" + id));
		}

		return response;
	}

	@Override
	public Response<String> updateCustomer(Customer customer) {
		Response<String> response = new Response<String>();

		// Forming data
		List<Customer> customers = new ArrayList<Customer>();
		Customer customer1 = new Customer("cu001", "customer01", 18, "1234567890", "infy@infy.com", Gender.MALE,
				Status.active);
		Customer customer2 = new Customer("cu002", "customer02", 19, "1234567899", "infy1@infy.com", Gender.FEMALE,
				Status.active);
		customers.add(customer1);
		customers.add(customer2);
		boolean customerFound = false;
		
		for (Customer customerTobeUpdated : customers) {
			if (customerTobeUpdated.getId().equals(customer.getId())) {
				customerFound = true;
				customerTobeUpdated.setAge(customer.getAge());
				customerTobeUpdated.setEmail(customer.getEmail());
				customerTobeUpdated.setGender(customer.getGender());
				customerTobeUpdated.setName(customer.getName());
				customerTobeUpdated.setPhone(customer.getPhone());
				customerTobeUpdated.setStatus(customer.getStatus());
				
				response.setCustomer(customerTobeUpdated);
			}
		}
		
		if (customerFound) {
			response.setMessages(Arrays.asList("Customer Updated Successfully for ID:" + customer.getId()));
		} else {
			response.setMessages(Arrays.asList("Customer Not Found for ID:" + customer.getId()));
		}

		return response;
		
	}

	@Override
	public Response<String> deactivateCustomer(Customer customer) {
		Response<String> response = new Response<String>();

		// Forming data
		List<Customer> customers = new ArrayList<Customer>();
		Customer customer1 = new Customer("cu001", "customer01", 18, "1234567890", "infy@infy.com", Gender.MALE,
				Status.active);
		Customer customer2 = new Customer("cu002", "customer02", 19, "1234567899", "infy1@infy.com", Gender.FEMALE,
				Status.active);
		customers.add(customer1);
		customers.add(customer2);
		boolean customerFound = false;
		
		for (Customer customerTobeUpdated : customers) {
			if (customerTobeUpdated.getId().equals(customer.getId())) {
				customerFound = true;
				customerTobeUpdated.setStatus(Status.inactive);
				response.setCustomer(customerTobeUpdated);
			}
		}
		
		if (customerFound) {
			response.setMessages(Arrays.asList("Customer inactivated Successfully for ID:" + customer.getId()));
		} else {
			response.setMessages(Arrays.asList("Customer Not Found for ID:" + customer.getId()));
		}

		return response;
	}

}
