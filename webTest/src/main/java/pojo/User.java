package pojo;

import java.util.Date;

/**
 * Created by CHENCO7 on 7/24/2017.
 */
public class User {
    private String uname;
    private String password;
    private double sal;
    private Date birth;
    private Boolean sex;

    public User(String uname, String password) {
        this.uname = uname;
        this.password = password;
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

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
