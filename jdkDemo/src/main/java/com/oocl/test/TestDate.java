package com.oocl.test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * Created by CHENCO7 on 7/10/2017.
 */
public class TestDate {
    public static void main(String[] args) {
        System.out.println(new Date(0));
        Date d1 = new Date();
        Date d2 = new Date();
        System.out.println(d1.getTime() == d2.getTime());
        d1.before(d2);

    }
}
