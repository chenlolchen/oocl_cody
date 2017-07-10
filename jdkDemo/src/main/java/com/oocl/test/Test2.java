package com.oocl.test;

import java.io.UnsupportedEncodingException;

/**
 * Created by CHENCO7 on 7/10/2017.
 */
public class Test2 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        /**
         *   String s1 = new String("abc");
             //使用 = 会有缓存
             //使用 new 则没缓存
             String s2 = "abc";
             String s3 = "abc";
             //true
             System.out.println(s2 == s3);
             //false
             System.out.println(s1 == s3);

             String s4 = s1.replace('a','x');
             System.out.println(s1);
         */

        String s = "a东asdsd,sdw,adsd,asdw国";
        byte[] bs = s.getBytes("gbk");
        String s1 = new String(bs,"gbk");
//        System.out.println(s1);
//        for(byte b : bs){
//            System.out.println(b);
//        }

//        System.out.println(s.charAt(1));
//        for (int i = 0; i < s.length(); i++){
//            String c = String.valueOf(s.charAt(i));
//            if(c.getBytes().length < 2){
//                System.out.print(c);
//            }
//        }

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c >= 'a' && c <= 'z'){
                System.out.print(c);
            }
        }

        System.out.println("");
        String sn = "";
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c >= 'a' && c <= 'z'){
                sn += (c + "");
            }
        }
        System.out.println(sn);

        char[] chars = new char[s.length()];
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c >= 'a' && c <= 'z'){
                chars[count++] = c;
            }
        }
        System.out.println(new String(chars, 0, count));

        String ss = new String(" ab,bdae");
        System.out.println(ss.codePointAt(1));
        ss.replaceAll("a","-");

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("aaa");
        stringBuffer.append("ooo");
        System.out.println(stringBuffer);

    }
}
