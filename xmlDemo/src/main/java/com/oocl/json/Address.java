package com.oocl.json;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Created by CHENCO7 on 7/19/2017.
 */
public class Address {
    private Integer id;
    private String city;
    @JsonBackReference
    private Customer customer;

    public Address() {
    }

    public Address(Integer id, String city) {
        this.id = id;
        this.city = city;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                '}';
    }
}
