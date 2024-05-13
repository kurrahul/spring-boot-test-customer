package com.infy.service;

import com.infy.model.Customer;
import com.infy.model.Response;

public interface CustomerService {
	public Response<String> addCustomer(Customer customer);
	public Response<String> findCustomer(String id);
	public Response<String> updateCustomer(Customer customer);
	public Response<String> deactivateCustomer(Customer customer);

}
