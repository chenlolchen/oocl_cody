package com.oocl.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by CHENCO7 on 7/10/2017.
 */
public class TestCalendar {
    public static void main(String[] args) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));
        calendar.set(1999,10,1,12,23);
        Date date = calendar.getTime();
        System.out.println(date);

        String[] s = TimeZone.getAvailableIDs();
        for (String s1 : s){
            System.out.println(s1);
        }

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String result = dateFormat.format(date);
        System.out.println(result);
        Date dd = dateFormat.parse(result);
        System.out.println(dd);

        java.sql.Date sql_date = new java.sql.Date(1999,2,3);
        Date dd2 = new Date(sql_date.getTime());
        System.out.println(dd2);
//        java -d
    }
}
