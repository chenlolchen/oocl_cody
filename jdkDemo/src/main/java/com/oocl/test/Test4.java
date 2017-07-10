package com.oocl.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by CHENCO7 on 7/10/2017.
 */
public class Test4 {
    public static void main(String[] args) {
        String s = "ab cd   abd,ab2d";
//        Pattern p = Pattern.compile("\\u0061");
//        Pattern p = Pattern.compile("\\x61");
//        Pattern p = Pattern.compile("[a-c]");
//        Pattern p = Pattern.compile("\\d"); [0-9] \\D 取反
//        Pattern p = Pattern.compile("\\w"); [a-z, 0-9] \\W 取反
//        Pattern p = Pattern.compile("[^bc]"); //排除bc
//        Pattern p = Pattern.compile("^a"); //a 开头

        String v1 = "aaa";
        String r = "^[a-zA-Z_]\\w*";
        Pattern p = Pattern.compile(r);
        Matcher m = p.matcher(v1);
        while (m.find()){
            System.out.println(m.start() + "..." + m.end() + "..." + m.group());
        }



    }
}
