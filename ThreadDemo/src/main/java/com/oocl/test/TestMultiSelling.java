package com.oocl.test;

/**
 * Created by CHENCO7 on 7/12/2017.
 */
public class TestMultiSelling {
    public static void main(String[] args) {
        Ticket[] tickets = new Ticket[100];
        for (int i = 0; i < tickets.length; i++) {
            tickets[i] = new Ticket(i, false);
        }

        Seller se = new Seller(tickets, "john");
        Seller se2 = new Seller(tickets, "tom");

        //进入Runnable状态
        se.start();
        se2.start();

    }
}

class Seller extends Thread {
    private Ticket[] ts;
    private String name;

    public Seller(Ticket[] ts, String name) {
        this.ts = ts;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < ts.length; i++) {
            //ts 是共同竞争的资源对象, 假如传this的话, 则会是两个不同的竞争对象
            synchronized (ts) {
                if (!ts[i].isSold()) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ts[i].setSold(true);
                    System.out.println(name + "... selling .... " + ts[i].getNum());
                }
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class Ticket {
    private int num;
    private boolean sold;

    public Ticket(int num, boolean sold) {
        this.num = num;
        this.sold = sold;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }
}
