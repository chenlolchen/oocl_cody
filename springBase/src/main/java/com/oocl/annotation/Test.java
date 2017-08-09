package com.oocl.annotation;

/**
 * Created by CHENCO7 on 8/9/2017.
 */
public class Test {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person);
        CustomUtils.getInfo(Person.class);
    }
}
