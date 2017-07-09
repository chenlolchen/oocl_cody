package com.oocl.crm.util;

import com.oocl.crm.exception.FormatException;

/**
 * Created by chen on 2017/7/9.
 */
public class FormatPrinter {
    public static String fetchOperationType(String inputStr){
        return String.valueOf(inputStr.charAt(0));
    }

    public static String parseInputString(String inputStr){
        if (inputStr.length() > 2) {
            if (inputStr.charAt(1) == ' ') {
                return inputStr.substring(2, inputStr.length());
            } else {
                throw new FormatException();
            }
        } else if (inputStr.length() == 1 && inputStr.equals("L")) {
            return inputStr;
        } else {
            return null;
        }
    }
}
