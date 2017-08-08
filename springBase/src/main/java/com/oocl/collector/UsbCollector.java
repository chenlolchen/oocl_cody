package com.oocl.collector;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by CHENCO7 on 8/8/2017.
 */
@Repository(value = "uc")
public class UsbCollector implements Collector {
    public void collect() {
        System.out.println("Usb collect ..");
    }
}
