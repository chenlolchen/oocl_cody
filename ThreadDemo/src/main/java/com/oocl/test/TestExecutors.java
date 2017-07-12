package com.oocl.test;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by CHENCO7 on 7/12/2017.
 */
public class TestExecutors {
    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("chen aaa .");
            }
        },2000,1000);
        Thread.sleep(6000);
        timer.cancel();

//        ExecutorService pool = Executors.newFixedThreadPool(3);
//        MyThread2 m1 = new MyThread2("chen");
//        MyThread2 m2 = new MyThread2("ooo");
//        MyThread2 m3 = new MyThread2("pppp");
//        pool.execute(m1);
//        pool.execute(m3);
//        pool.execute(m2);
    }
}

class MyThread2 implements Runnable{
    private String name;

    public MyThread2(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 100; i++){
            System.out.println(name + " ... " +i);
        }
    }
}
