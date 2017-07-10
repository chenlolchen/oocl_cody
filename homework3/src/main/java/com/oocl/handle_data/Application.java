package com.oocl.handle_data;

import com.oocl.handle_data.controller.CustomerController;
import com.oocl.handle_data.controller.impl.CustomerControllerImpl;

import java.io.FileNotFoundException;

/**
 * Created by CHENCO7 on 7/10/2017.
 */
public class Application {
    public static void main(String[] args) throws FileNotFoundException {
        CustomerController customerController = new CustomerControllerImpl();
        customerController.scanner();
        System.out.println("sort by id:");
        customerController.outputBySortId();
        System.out.println("sort by date:");
        customerController.outputBySortDate();
        System.out.println("output xml:");
        customerController.outputXml();
    }
}
