package com.oocl.collector;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by CHENCO7 on 8/8/2017.
 */
@Repository
public class NetCollector implements Collector, BeanNameAware {
    private String cname;
    private List<String> favs;

    public NetCollector(){
        System.out.println("net construct");
    }

    public NetCollector(String cname, boolean sex) {
        this.cname = cname;
        System.out.println("cname: " + cname);
        System.out.println("sex: " + sex);
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public List<String> getFavs() {
        return favs;
    }

    public void setFavs(List<String> favs) {
        this.favs = favs;
    }

    public void collect() {
        System.out.println("Net collect ..");
    }

    public void init() {
        System.out.println("init ... ");
    }

    public void destroy() {
        System.out.println("destroy ... ");
    }

    public void setBeanName(String name) {
        System.out.println("bean name ...");
    }
}
