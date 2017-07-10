package com.oocl.test;

import java.util.*;

/**
 * Created by CHENCO7 on 7/10/2017.
 */
public class TestList {
    public static void main(String[] args) {
//        List<String> sl1 = new ArrayList<String>();
        List<String> sl1 = new LinkedList<String>();
        String o = "ooo";

        sl1.add("aa");
        sl1.add(o);
        sl1.add("bbb");
        sl1.add("cc");
        sl1.add(o);
        sl1.add("dd");

//        sl1.remove(0);
//        sl1.remove(o);
//        sl1.remove("cc");

//        sl1.set(4,"test");

        Collections.sort(sl1);
        int index = Collections.binarySearch(sl1,"dd");

        for(String s: sl1){
            System.out.println(s);
        }

        System.out.println(index);
    }
}
