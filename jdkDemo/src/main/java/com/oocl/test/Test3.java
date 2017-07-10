package com.oocl.test;

/**
 * Created by CHENCO7 on 7/10/2017.
 */
public class Test3 {
    public static void main(String[] args) {
        String reg = "a";
        String t1 = "bdea";
        String t2 = "a b dfd    dfd d";
        System.out.println(t1.matches("a"));
        String[] rgs = t2.split("\\s");
        for(String s : rgs){
            System.out.println(s);
        }
        String rgs1 = t2.replaceAll("\\s", "o");
        System.out.println(rgs1);
    }
}
