//package com.oocl.json;
//
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//import java.util.Date;
//
///**
// * Created by CHENCO7 on 7/19/2017.
// */
//public class OrgJsonTest {
//    public static void main(String[] args) {
//        JSONObject jsonObject = new JSONObject();
//        JSONObject city = new JSONObject();
//        city.put("id", "c1");
//        city.put("city", "bj");
//        jsonObject.put("addr", city);
//
//        jsonObject.put("id", "a1");
//        jsonObject.put("name", "john");
//        jsonObject.put("age", 23);
//        jsonObject.put("salary", 35.66);
//        jsonObject.put("sex", true);
//        jsonObject.put("birth", new Date());
//        jsonObject.put("favs", new String[]{"basket", "swim"});
//
//        System.out.println(jsonObject.toString());
//
//        String str = jsonObject.toString();
//        JSONObject jsonObject1 = new JSONObject(str);
//        System.out.println(jsonObject1.get("name"));
//        JSONArray favs = (JSONArray) jsonObject1.get("favs");
//        for (int i = 0; i < favs.length(); i++) {
//            System.out.println(favs.get(i));
//        }
//
//    }
//}
