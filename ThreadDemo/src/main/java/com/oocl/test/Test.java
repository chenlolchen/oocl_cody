package com.oocl.test;

/**
 * Created by CHENCO7 on 7/12/2017.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        Thread t = new MyThread();
        t.setDaemon(true);

        for(int i = 0; i < 100; i++){
            if(i == 20){
                t.start();
                System.out.println("aaaaaaaaaaaaaa");
            }
            sleep(1);
            System.out.println(i);
        }
    }

    public static void sleep(int m){
        try {
            Thread.sleep(m);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            System.out.println(i + ".............");
            Test.sleep(1);
        }
    }
}
