package com.oocl.test;

/**
 * Created by CHENCO7 on 7/10/2017.
 */
public class Test7 {
    public static void main(String[] args) {
        String[][] s = new String[2][];
        s[0] = new String[6];
        s[1] = new String[6];
        s[1][5] = "aa";
        for (String[] s1 : s){
            for(String s2: s1){
                System.out.println(s2);
            }
        }
    }
}
