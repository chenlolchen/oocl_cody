package com.oocl.test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by CHENCO7 on 7/12/2017.
 */
public class TestProCon {
    public static void main(String[] args) {
        Queue<Integer> base = new LinkedList<Integer>();
        String[] ss = new String[10];
        Producer p = new Producer(base,ss);
        Consumer c = new Consumer(base,ss);

        new Thread(p).start();
        new Thread(c).start();
    }

    public static void sleep(int m){
        try {
            Thread.sleep(m);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Producer implements Runnable{
    private Queue<Integer> base = new LinkedList<Integer>();
    private String[] ss;

    public Producer(Queue<Integer> base) {
        this.base = base;
    }

    public Producer(Queue<Integer> base, String[] ss) {
        this.base = base;
        this.ss = ss;
    }

    public void run() {
        while (true){
            synchronized (base){
                if(base.size() <= 5){
                    int item = (int) (Math.random() * 11);
                    base.add(item);
                    System.out.println("producer ..." + item);
                    base.notify();
                }else {
                    System.out.println("base is full ... ");
                    try {
                        System.out.println(base.toString());
                        base.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            TestProCon.sleep(20);
        }
    }
}


class Consumer implements Runnable{
    private Queue<Integer> base = new LinkedList<Integer>();
    private String[] ss;

    public Consumer(Queue<Integer> base) {
        this.base = base;
    }

    public Consumer(Queue<Integer> base, String[] ss) {
        this.base = base;
        this.ss = ss;
    }

    public void run() {
        while (true){
            synchronized (base){
                if(!base.isEmpty()){
                    int item = base.poll();
                    System.out.println("consumer ..." + item);
                    base.notify();
                }else {
                    System.out.println("base is empty");
                    try {
                        System.out.println(base.toString());
                        base.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            TestProCon.sleep(200);
        }
    }
}
