package com.oocl.test;

import java.math.BigDecimal;

/**
 * Created by CHENCO7 on 7/10/2017.
 */
public class Test6 {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("9499879788888665465413199789797999666666");
        BigDecimal bigDecimal2 = new BigDecimal("19499879788888665465413199789797999666666");
        BigDecimal bigDecimal3 = bigDecimal.multiply(bigDecimal2);
        System.out.println(bigDecimal3.toString());
    }
}
