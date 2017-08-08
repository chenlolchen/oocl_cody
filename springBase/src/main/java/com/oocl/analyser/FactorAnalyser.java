package com.oocl.analyser;

import com.oocl.collector.Collector;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by CHENCO7 on 8/8/2017.
 */
public class FactorAnalyser implements Analyser {
    private Collector collector;

    public Collector getCollector() {
        return collector;
    }

    public void setCollector(Collector collector) {
        this.collector = collector;
    }

    public void analyse() {
        collector.collect();
        System.out.println("factor analysing");
    }
}
