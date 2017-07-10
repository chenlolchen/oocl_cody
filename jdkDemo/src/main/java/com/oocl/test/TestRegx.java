package com.oocl.test;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by CHENCO7 on 7/10/2017.
 */
public class TestRegx {
    public static void main(String[] args) {
        String v = "111-66-55";
        String r = "^\\d{3}-\\d{2}-\\d{2}$";
        Pattern p = Pattern.compile(r);
        Matcher m = p.matcher(v);
        System.out.println(m.find());

        String v2 = "5362x";
//        String r2 = "^\\d{3}$|^\\d{5}$";
        String r2 = "(^\\d{3}$)|(^\\d{4}[xX]$)";
        Pattern p2 = Pattern.compile(r2);
        Matcher m2 = p2.matcher(v2);
        System.out.println(m2.find());

        String v3 = "asdabdfdab";
        String r3 = "(a)(b)";
        Pattern p3 = Pattern.compile(r3);
        Matcher m3 = p3.matcher(v3);
        System.out.println(m3.find());

        String v4 = "2013-06-08";
//        String r4 = "^{1900,2017}-[0-9][0-9]-[0-3][0-9]";
        String r4 = "((19\\d{2})|(20([0]\\d)|([1][0-7])))[-/](0?\\d|1[0-2])[/-](0?\\d|12\\d|3[01])";
        Pattern p4 = Pattern.compile(r4);
        Matcher m4 = p4.matcher(v4);
        System.out.println(m4.find());

        String v5 = "adsfsd,adfsdf2,34343asdf,aaf.";
        String r5 = "[a-zA-Z0-9]";
        Pattern p5 = Pattern.compile(r5);
        Matcher m5 = p5.matcher(v5);
        int count = 0;
        while (m5.find()){
            count++;
        }
        System.out.println(count);

//        \u2312 汉字

//        System.out.println(new Scanner("abc.txt").next());
    }
}
