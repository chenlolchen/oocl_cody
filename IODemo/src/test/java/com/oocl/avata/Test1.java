package com.oocl.avata;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;

import org.junit.*;

import javax.imageio.ImageIO;

/**
 * Created by CHENCO7 on 7/11/2017.
 */
public class Test1 {

    @Test
    public void testOutput() throws Exception {
            OutputStream out = null;
            out = new FileOutputStream(new File("data.txt"));
            byte[] buf = new byte[26];
            for (int i = 97; i < 97 + 26; i++){
                buf[i - 97] = (byte)i;
            }
            out.write(buf);

            out.close();
    }

    @Test
    public void testOutput2() throws Exception {
        OutputStream out = null;
        out = new FileOutputStream(new File("data1.txt"));
        String s = "东方海外啊";
        out.write(s.getBytes());
        out.close();
    }

    @Test
    public void testOutput3() throws Exception {
        OutputStream out = null;
        out = new FileOutputStream(new File("data2.txt"));
        String s = "东方海外啊";
        out.write(s.getBytes("gbk"));
        out.close();
    }

    @Test
    public void testOutput4() throws Exception {
        OutputStream out = new ByteArrayOutputStream(1024);
        out.write("abcd".getBytes());
        out.close();
        ByteArrayOutputStream out1 = (ByteArrayOutputStream) out;
        byte[] bs = out1.toByteArray();
        System.out.println(bs[0]);

        InputStream in = new ByteArrayInputStream(bs);
        int m = in.read();
        System.out.println(m);
        in.close();
    }

    @Test
    public void testInput() throws Exception {
        InputStream in = null;
        OutputStream out = null;
        in = new FileInputStream(new File("data.txt"));

        int m = in.read();
        m  = in.read();
        in.skip(1);
        System.out.println((char)m);

        in.close();
    }

    @Test
    public void testInput2() throws Exception {
        byte[] buf = new byte[26];
        InputStream in = new FileInputStream(new File("data.txt"));

        int count = in.read(buf,0,5);
        for(int i = 0; i < count; i++){
            System.out.println((char)buf[i]);
        }
        in.close();
    }

    @Test
    public void testInput3() throws Exception {
        InputStream in = new FileInputStream(new File("data.txt"));
        int m;
        while ((m = in.read()) != -1){
            System.out.println((char)m);
        }
        in.close();
    }

    @Test
    public void testInput4() throws Exception {
        InputStream in = new FileInputStream(new File("data.txt"));
        byte[] buf = new byte[in.available()];
//        in.read(buf);
//        String s = new String(buf,"utf-8");
//        System.out.println(s);

        int m;
        while ((m = in.read(buf,0,5)) != -1){
            System.out.println(new String(buf, "utf-8"));
        }
        in.close();
    }

    @Test
    public void testInput5() throws Exception {
        InputStream in = new FileInputStream(new File("data.txt"));
        byte[] buf = new byte[6];

        int m;
        while ((m = in.read(buf)) != -1){
            //不能为 buf.length 因为存在越界问题
//            for (int i = 0; i < buf.length; i++){
//                System.out.println((char)buf[i]);
//            }
            for (int i = 0; i < m; i++){
                System.out.println((char)buf[i]);
            }
            System.out.println("===========================");
//            System.out.println(new String(buf, "utf-8"));
        }
        in.close();
    }

    @Test
    public void testInput6() throws Exception {
        InputStream in = new FileInputStream(new File("data2.txt"));
        byte[] buf = new byte[in.available()];
        in.read(buf);
//        String s = new String(buf, "utf-8");
        String s = new String(buf, "gbk");
        System.out.println(s);
        in.close();
    }

    @Test
    public void testInput7() throws Exception {
        String a = "测";
        System.out.println(a.getBytes().length);
        System.out.println(a.getBytes("gbk").length);
        InputStream in = new FileInputStream(new File("data1.txt"));
        byte[] buf = new byte[3];
        int count = 0;
        while ((count = in.read(buf)) != -1) {
            String s = new String(buf);
            System.out.println(s);
        }
        in.close();
    }

    @Test
    public void testCopy() throws Exception{
        long start = System.currentTimeMillis();
        InputStream in = new FileInputStream("aa.png");
        OutputStream out = new FileOutputStream("aa2.png");
        int m = 0;
        while ((m = in.read()) != -1){
            out.write((byte)m);
        }
        in.close();
        out.close();
        long end = System.currentTimeMillis();
        System.out.println("spand time:" + (end - start));
    }

    @Test
    public void testCopy2() throws Exception{
        long start = System.currentTimeMillis();
        InputStream in = new FileInputStream("aa.png");
        OutputStream out = new FileOutputStream("aa2.png");
        byte[] buf = new byte[10240];
        int m = 0;
        while ((m = in.read(buf)) != -1){
//            out.write(buf);
            out.write(buf, 0, m);
        }
        in.close();
        out.close();
        long end = System.currentTimeMillis();
        System.out.println("spand time:" + (end - start));
    }

    @Test
    public void testCopy3() throws Exception {
        BufferedImage image = ImageIO.read(new File("avata.png"));

        Graphics g = image.getGraphics();
        g.setColor(Color.black);
        g.setFont(g.getFont().deriveFont(30f));
        g.drawString("CODY", 400, 150);
        g.dispose();

        ImageIO.write(image, "png", new File("test22.png"));

    }

    @Test
    public void testCopy4() throws Exception {
        byte[] info = "CODY".getBytes();
        long start = System.currentTimeMillis();
        InputStream in = new FileInputStream("aa.png");
        OutputStream out = new FileOutputStream("aa2.png");
        byte[] buf = new byte[10240];
        int m = 0;
        while ((m = in.read(buf)) != -1){
//            out.write(buf);
            out.write(buf, 0, m);
        }
        in.close();
        out.close();
        long end = System.currentTimeMillis();
        System.out.println("spand time:" + (end - start));

    }

    @Test
    public void testDataOutputStream() throws Exception {
        double d = 34.5678;
        OutputStream out = new FileOutputStream("data3.txt");
        DataOutputStream dataOutputStream = new DataOutputStream(out);
        dataOutputStream.writeDouble(d);
        dataOutputStream.close();
    }

    @Test
    public void testDataInputStream() throws Exception {
        InputStream in = new FileInputStream("data3.txt");
        DataInputStream dataInputStream = new DataInputStream(in);
        System.out.println(dataInputStream.readDouble());
    }

    @Test
    public void testBufferInputStream() throws Exception {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("aa.png"));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("aa3.png"));
        int m = 0;
        while ((m = bufferedInputStream.read()) != -1){
            bufferedOutputStream.write((byte)m);
        }
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }

    @Test
    public void testBufferInputStream2() throws Exception {
        long start = System.currentTimeMillis();
        Random random = new Random();
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("tt.txt")));
        for(int i = 0; i < 1000000; i++){
            out.writeInt(random.nextInt(100));
        }
        out.close();
        long end = System.currentTimeMillis();
        System.out.println("spand time:" + (end - start));
    }

}