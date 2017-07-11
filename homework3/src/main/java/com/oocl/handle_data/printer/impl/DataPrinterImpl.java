package com.oocl.handle_data.printer.impl;

import com.oocl.handle_data.pojo.Customer;
import com.oocl.handle_data.printer.DataPrinter;

import java.util.Set;

public class DataPrinterImpl implements DataPrinter {

	public StringBuilder print(Set<Customer> customers, String format) {
		StringBuilder sb = new StringBuilder();

		if("xml".equals(format)){
			sb.append("<Customers>\n");
			for (Customer customer : customers) {
				sb.append("\t<customer.id='" + customer.getId() + "'>\n");
				sb.append("\t\t<name>" + customer.getName() + "</name>\n");
				sb.append("\t\t<sex>" + customer.getSex() + "</sex>\n");
				sb.append("\t\t<birthday>" + customer.getBirthDay() + "</birthday>\n");
				sb.append("\t\t<email>" + customer.getEmail() + "</email>\n");
				sb.append("\t</customer>\n");
			}
			sb.append("</Customers>\n");
			return sb;
		}
		else if("line".equals(format)){
			for(Customer customer : customers){
				sb.append(customer.toString() + "\n");
			}
			return sb;
		}
		return null;
	}

}
