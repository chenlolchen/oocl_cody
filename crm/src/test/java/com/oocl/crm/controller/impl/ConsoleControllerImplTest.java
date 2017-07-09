package com.oocl.crm.controller.impl;

import com.oocl.crm.controller.ConsoleController;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by chen on 2017/7/9.
 */
public class ConsoleControllerImplTest {
    public static ConsoleController consoleController;

    @BeforeClass
    public static void init(){
        consoleController = new ConsoleControllerImpl();
    }

    @Test
    public void showHelp() throws Exception {
        consoleController.showHelp("H");
    }

    @Test
    public void handleInput() throws Exception {
        consoleController.handleInput("L name:小明");
    }

}