package com.oocl.handle_data.pojo;

import java.util.Date;

/**
 * Created by CHENCO7 on 7/10/2017.
 */
public class Customer {
    private int id;
    private String birthDay;
    private Boolean sex;
    private String email;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", birthDay='" + birthDay + '\'' +
                ", sex=" + sex +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
