package com.oocl.jdbc.pojo;

import java.util.Date;

/**
 * Created by CHENCO7 on 7/18/2017.
 */
public class Customer {
    private Integer id;
    private String cname;
    private boolean sex;
    private double sal;
    private Date birth;

    public Customer() {
    }

    public Customer(Integer id, String cname, boolean sex, double sal, Date birth) {
        this.id = id;
        this.cname = cname;
        this.sex = sex;
        this.sal = sal;
        this.birth = birth;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", cname='" + cname + '\'' +
                ", sex=" + sex +
                ", sal=" + sal +
                ", birth=" + birth +
                '}';
    }
}
