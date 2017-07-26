package com.oocl.test;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by CHENCO7 on 7/26/2017.
 */
public class UrlConnectionTest2 {
    public static void main(String[] args) throws Exception {
        String body = "name=abcdefg&sal=457&birth=2017-07-10&sex=true&favs=basket";
        URL url = new URL("http://localhost:8081/sec/add");
        URLConnection connection = url.openConnection();
        HttpURLConnection httpURLConnection = (HttpURLConnection) connection;
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Cookie","JSESSIONID=1FEB7FC49CCCE92A55634A6B33DF3C20");
        httpURLConnection.setDoOutput(true); // 只有设置了才能输东西, 必须在getInputStream 之前设置
        OutputStream out = httpURLConnection.getOutputStream();
        out.write(body.getBytes());
        int len = httpURLConnection.getContentLength();
        InputStream in = httpURLConnection.getInputStream();
        byte[] buf = new byte[len];
        in.read(buf);
        in.close();
        httpURLConnection.disconnect();
        System.out.println(new String(buf));

//        name=chen&sal=457&birth=2017-07-10&sex=true&favs=basket
    }
}
