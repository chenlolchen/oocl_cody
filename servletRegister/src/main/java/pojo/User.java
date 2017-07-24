package pojo;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by CHENCO7 on 7/24/2017.
 */
public class User {
    private Integer id;
    private String name;
    private Double salary;
    private Date birth;
    private Boolean sex;
    private byte[] avatar;

    public User() {
    }

    public User(String name, Double salary, Date birth, Boolean sex) {
        this.name = name;
        this.salary = salary;
        this.birth = birth;
        this.sex = sex;
    }

    public User(String name, Double salary, Date birth, Boolean sex, byte[] avatar) {
        this.name = name;
        this.salary = salary;
        this.birth = birth;
        this.sex = sex;
        this.avatar = avatar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", birth=" + birth +
                ", sex=" + sex +
                ", avatar=" + Arrays.toString(avatar) +
                '}';
    }
}
