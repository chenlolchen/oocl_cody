package com.oocl.analyser;

import com.oocl.collector.Collector;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


/**
 * Created by CHENCO7 on 8/8/2017.
 */
@Component
public class ClusterAnalyser implements Analyser {
//    @Qualifier(value = "uc")
//    @Autowired
    @Resource(name = "uc")
    private Collector collector;

    public void setCollector(Collector collector) {
        this.collector = collector;
    }

    public void analyse() {
        collector.collect();
        System.out.println("cluster analysing");
    }
}
