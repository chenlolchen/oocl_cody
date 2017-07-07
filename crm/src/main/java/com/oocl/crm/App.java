package com.oocl.crm;

import com.oocl.crm.bean.DoubleLink;
import com.oocl.crm.util.ConsoleUtil;
import com.oocl.crm.util.DataUtil;

public class App {
    public static void main(String[] args) {
        DoubleLink doubleLink = new DoubleLink();
        doubleLink.initData();

        DataUtil dataUtil = new DataUtil(doubleLink);
        ConsoleUtil consoleUtil = new ConsoleUtil(dataUtil);
        consoleUtil.showHelp("H");
        consoleUtil.start();
    }
}
