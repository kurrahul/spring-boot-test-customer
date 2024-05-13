package com.infy.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.infy.model.Customer;

//@Component
public class CustomerValidator {

	public static List<String> validateForAdd(Customer customer) {
		List<String> errorMsgs = new ArrayList<String>();

		// name
		// Regular expression to match letters only
		String regex = "^[a-zA-Z]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(customer.getName());
		if (!matcher.matches()) {
			errorMsgs.add("Name should contains letter only");
		}

		// age
		if (customer.getAge() < 18) {
			errorMsgs.add("Age should be greater or 18 only");
		}

		// Phone
		regex = "^[0-9]{10}$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(customer.getPhone());
		if (!matcher.matches()) {
			errorMsgs.add("Phone number should contains 10 digit only");
		}

		// email
		regex = "^[a-zA-Z]+$";
		String[] parts = customer.getEmail().split("@");
		if (parts.length != 2) {
			errorMsgs.add("Email should contain exactly one @ symbol");
		} else {
			pattern = Pattern.compile(regex);
			matcher = pattern.matcher(parts[0]);
			if (!matcher.matches()) {
				errorMsgs.add("Email should contains alphabet only");
			}
		}

		// gender
		// Gender.valueOf(customer.getGender());

		// status
		// Status.valueOf(customer.getGender());
		return errorMsgs;
	}

}
