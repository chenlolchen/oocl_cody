package pojo;

import java.util.Date;

/**
 * Created by CHENCO7 on 7/25/2017.
 */
public class Customer {
    private Integer id;
    private String name;
    private Double sal;
    private boolean sex;
    private Date birth;
    private String[] favs;

    public Customer() {
    }

    public Customer(Integer id, String name, Double sal, boolean sex, Date birth, String[] favs) {
        this.id = id;
        this.name = name;
        this.sal = sal;
        this.sex = sex;
        this.birth = birth;
        this.favs = favs;
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

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String[] getFavs() {
        return favs;
    }

    public void setFavs(String[] favs) {
        this.favs = favs;
    }
}
