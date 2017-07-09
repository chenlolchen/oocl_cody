package com.oocl.crm;

import com.oocl.crm.controller.ConsoleController;
import com.oocl.crm.controller.impl.ConsoleControllerImpl;

public class App {
    public static void main(String[] args) {
        ConsoleController consoleController = new ConsoleControllerImpl();
        consoleController.start();
    }
}
