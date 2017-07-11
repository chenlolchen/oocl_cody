package com.oocl.handle_data.controller.impl;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by CHENCO7 on 7/10/2017.
 */
public class CustomerControllerImplTest {
    private static CustomerControllerImpl customerController;

    @BeforeClass
    public static void init(){
        customerController = new CustomerControllerImpl();
    }


    @Test
    public void scanner() throws Exception {
        customerController.scanner("data.txt");
    }

    @Test
    public void outputBySortId() throws Exception {
        customerController.scanner("data.txt");
        customerController.outputBySortId();
    }

    @Test
    public void outputBySortDate() throws Exception {
        customerController.scanner("data.txt");
        customerController.outputBySortDate();
    }

    @Test
    public void outputXml() throws Exception {
        customerController.scanner("data.txt");
        customerController.outputXml();
    }

}