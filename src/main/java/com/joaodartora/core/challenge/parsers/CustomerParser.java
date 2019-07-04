package com.joaodartora.core.challenge.parsers;

import com.joaodartora.core.challenge.model.Customer;

public class CustomerParser {

	public Customer processCustomerData (String lineReaded, String delimiter) {
		String[] lineParsed = lineReaded.split(delimiter);
		return new Customer(lineParsed[1], lineParsed[2], lineParsed[3]);
	}
}
