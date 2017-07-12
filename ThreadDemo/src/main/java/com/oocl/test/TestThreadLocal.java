package com.oocl.test;

/**
 * Created by CHENCO7 on 7/12/2017.
 */
public class TestThreadLocal {
    public static ThreadLocal<String> local = new ThreadLocal<String>();
    public static void main(String[] args) throws InterruptedException {
        local.set("chen");
//        System.out.println(local.get());

        new Thread(){
            public void run(){
                local.set("tom");
                System.out.println(local.get());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(local.get());
            }
        }.start();

        Thread.sleep(1000);
        System.out.println(local.get());
    }
}
