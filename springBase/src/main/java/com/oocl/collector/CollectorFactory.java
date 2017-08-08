package com.oocl.collector;

/**
 * Created by CHENCO7 on 8/8/2017.
 */
public class CollectorFactory {
    private static Collector collector;
    static {
        collector = new UsbCollector();
    }

    public static Collector getInstance(){
        return collector;
    }
}
