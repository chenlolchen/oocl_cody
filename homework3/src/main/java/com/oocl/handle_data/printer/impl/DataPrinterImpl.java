package com.oocl.handle_data.printer.impl;

import com.oocl.handle_data.pojo.Customer;
import com.oocl.handle_data.printer.DataPrinter;

import java.util.Set;

public class DataPrinterImpl implements DataPrinter {

	public StringBuilder print(Set<Customer> customers, String format) {
		StringBuilder sb = new StringBuilder();

		if("xml".equals(format)){
			sb.append("<Customers>\n\r");
			for (Customer customer : customers) {
				sb.append("\t<customer.id='" + customer.getId() + "'>\n\r");
				sb.append("\t\t<name>" + customer.getName() + "</name>\n\r");
				sb.append("\t\t<sex>" + customer.getSex() + "</sex>\n\r");
				sb.append("\t\t<birthday>" + customer.getBirthDay() + "</birthday>\n\r");
				sb.append("\t\t<email>" + customer.getEmail() + "</email>\n\r");
				sb.append("\t</customer>\n\r");
			}
			sb.append("</Customers>\n\r");
			return sb;
		}
		else if("line".equals(format)){
			for(Customer customer : customers){
				sb.append(customer.toString() + "\r\n");
			}
			return sb;
		}
		return null;
	}

}
