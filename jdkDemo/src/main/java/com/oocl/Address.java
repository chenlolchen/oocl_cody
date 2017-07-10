package com.oocl;

/**
 * Created by CHENCO7 on 7/10/2017.
 */
public class Address implements Cloneable {
    public int city;

    @Override
    public Object clone() {
        Object o = null;
        try {
            o = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return o;
    }
}
