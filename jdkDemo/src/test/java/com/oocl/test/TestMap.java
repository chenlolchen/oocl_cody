package com.oocl.test;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * Created by CHENCO7 on 7/10/2017.
 */
public class TestMap {
    @Test
    public void test1(){
//        Map<String,String> map = new HashMap<String, String>();
//        Map<String,String> map = new TreeMap<String, String>();
        Map<String,String> map = new Hashtable<String, String>();
        map.put("a","abc");
        map.put("b","bcd");
        map.put("a","xyz");

//        map.remove("a");
        System.out.println(map.get("a"));
        System.out.println(map.size());

        for(String key: map.keySet()){
            System.out.println(key + "...." + map.get(key));
        }
    }

    @Test
    public void test2() throws Exception {
        Properties properties = new Properties();
        properties.put("a","abc");
        properties.put("b","bcd");
        properties.put("a","xyz");
        System.out.println(properties.size());
        properties.load(new FileInputStream("config.properties"));
        System.out.println(properties.get("name"));
    }

}
