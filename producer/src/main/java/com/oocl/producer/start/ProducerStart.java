package com.oocl.producer.start;

import com.oocl.producer.mq.PtpProducer;
import com.oocl.producer.pojo.Book;
import com.oocl.producer.xml.XmlAction;
import com.oocl.producer.xml.impl.XmlActionImpl;

import java.util.List;

/**
 * Created by CHENCO7 on 7/19/2017.
 */
public class ProducerStart {
    public static void main(String[] args) {
        XmlAction xmlAction = new XmlActionImpl();
        xmlAction.createXmlData(10000);
        List<Book> bookList = xmlAction.readData();

        // dataNumber: 对象个数, threadNumber: 启动线程数
        int dataNumber = bookList.size();
        int start = 0;
        int threadNumber = 5;
        int blockSize = dataNumber / threadNumber;
        int end = blockSize;
        PtpProducer producer;
        for(int i = 0; i < threadNumber - 1; i++){
            producer = new PtpProducer(start, end, bookList);
            new Thread(producer).start();
            start += blockSize;
            end += blockSize;
        }

        //处理最后一个模块
        producer = new PtpProducer(start, dataNumber, bookList);
        new Thread(producer).start();

    }
}
