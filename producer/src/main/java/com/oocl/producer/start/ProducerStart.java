package com.oocl.producer.start;

import com.oocl.producer.mq.PtpProducer;
import com.oocl.producer.xml.XmlAction;
import com.oocl.producer.xml.impl.XmlActionImpl;

/**
 * Created by CHENCO7 on 7/19/2017.
 */
public class ProducerStart {
    public static void main(String[] args) {
        XmlAction xmlAction = new XmlActionImpl();
        xmlAction.createXmlData(10000);
        PtpProducer producer = new PtpProducer();
        producer.start();
    }
}
