package com.oocl.crm.bean;

public class Student extends Object {
    private int id;
    private String name;
    private String sex;
    private String birthDay;
    private String address;
    private String call;

    public Student() {

    }

    public Student(int id, String name, String sex, String birthDay, String address, String call) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthDay = birthDay;
        this.address = address;
        this.call = call;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCall() {
        return call;
    }

    public void setCall(String call) {
        this.call = call;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", address='" + address + '\'' +
                ", call='" + call + '\'' +
                '}';
    }
}
