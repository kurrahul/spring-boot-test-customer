package com.infy.model;

import java.util.List;

public class Response<T> {
	private List<T> messages;
	private Customer customer;

	public Response(List<T> messages, Customer customer) {
		super();
		this.messages = messages;
		this.customer = customer;
	}
	
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Response(List<T> messages) {
		super();
		this.messages = messages;
	}

	public List<T> getMessages() {
		return messages;
	}

	public void setMessages(List<T> messages) {
		this.messages = messages;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
