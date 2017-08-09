package com.oocl.annotation;

/**
 * Created by CHENCO7 on 8/9/2017.
 */
public class Person {

    @Name("阿特罗伯斯")
    private String name;

    @Gender(gender = Gender.GenderType.Male)
    private String gender;

    @Profile(id = 1001, height = 180, nativePlace = "CN")
    private String profile;

    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", profile='" + profile + '\'' +
                '}';
    }
}