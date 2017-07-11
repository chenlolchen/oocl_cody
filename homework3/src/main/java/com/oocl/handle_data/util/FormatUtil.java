package com.oocl.handle_data.util;

import com.oocl.handle_data.exception.FormatException;
import com.oocl.handle_data.pojo.Customer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by CHENCO7 on 7/10/2017.
 */
public class FormatUtil {
    public static String[] formatSpace(String text) {
        return text.split("\\s+");
    }

    public static Map<String, String> formatCommand(String commmand) {
        String[] result = commmand.split(" ");
        Map<String,String> map = new HashMap<String, String>();
        if(result.length != 3){
            throw new FormatException("输入格式错误！");
        }else {
            if ((result[0].equals("L") || result[0].equals("C"))  &&
                    (result[1].equals("xml") || result[1].equals("line")) &&
                    (result[2].equals("id") || result[2].equals("birth"))) {
                map.put("operate", result[0]);
                map.put("type", result[1]);
                map.put("parameter", result[2]);
            }else {
                throw new FormatException("输入格式错误！");
            }
        }
        return map;
    }


}
