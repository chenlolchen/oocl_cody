package com.oocl.handle_data.printer;

import com.oocl.handle_data.pojo.Customer;

import java.util.Set;

public interface DataPrinter {
	public StringBuilder print(Set<Customer> customer, String format);
}
