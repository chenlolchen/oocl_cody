package com.oocl.consumer.start;

import com.oocl.consumer.mq.PtpConsumerAsyn;

/**
 * Created by CHENCO7 on 7/19/2017.
 */
public class ConsumerStart {
    public static void main(String[] args) {
        PtpConsumerAsyn ptpConsumerAsyn = new PtpConsumerAsyn();
        ptpConsumerAsyn.start();
    }
}
