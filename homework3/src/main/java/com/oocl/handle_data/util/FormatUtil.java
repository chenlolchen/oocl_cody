package com.oocl.handle_data.util;

import com.oocl.handle_data.pojo.Customer;

import java.util.Set;

/**
 * Created by CHENCO7 on 7/10/2017.
 */
public class FormatUtil {
    public static String[] formatSpace(String text) {
        return text.split("\\s+");
    }

    public static void formatXml(Set<Customer> set) {
        System.out.println("<Customers>");
        for (Customer cus : set) {
            System.out.println("\t<customer.id='" + cus.getId() + "'>");
            System.out.println("\t\t<name>" + cus.getName() + "</name>");
            System.out.println("\t\t<sex>" + cus.getSex() + "</sex>");
            System.out.println("\t\t<birthday>" + cus.getBirthDay() + "</nbirthday>");
            System.out.println("\t\t<email>" + cus.getEmail() + "</email>");
            System.out.println("\t</customer>");
        }
        System.out.println("</Customers>");
    }
}
