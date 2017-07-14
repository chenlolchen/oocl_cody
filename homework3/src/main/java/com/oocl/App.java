package com.oocl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Pattern p = Pattern.compile("\\w+");
        Matcher m = p.matcher(".");
        System.out.println(m.matches());
    }
}
