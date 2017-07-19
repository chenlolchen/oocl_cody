package com.oocl.json;

import com.fasterxml.jackson.annotation.*;

import java.util.Date;

/**
 * Created by CHENCO7 on 7/19/2017.
 */
public class Customer {
    private Integer id;
    @JsonProperty(value = "cname")
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birth;
    @JsonIgnore
    private double sal;
    private int age;
//    @JsonManagedReference(value = "address")
    private Address address;

    public Customer() {
    }

    public Customer(Integer id, String name, Date birth, double sal, int age) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.sal = sal;
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }
}
