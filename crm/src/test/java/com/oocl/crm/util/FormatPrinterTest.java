package com.oocl.crm.util;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by chen on 2017/7/9.
 */
public class FormatPrinterTest {
    @Test
    public void fetchOperationType() throws Exception {
        String s = FormatPrinter.fetchOperationType("L name:chen");
        Assert.assertEquals(s,"L");
    }

    @Test
    public void parseInputString() throws Exception {
        String s = FormatPrinter.parseInputString("L name:chen");
        Assert.assertEquals(s,"name:chen");
    }

}