package store.pojo;

import java.util.Date;

/**
 * Created by CHENCO7 on 7/26/2017.
 */
public class Cargo {
    private String id;
    private String name;
    private Double price;
    private Integer amount;
    private Date createdDate;
    private String storeId;

    public Cargo(String id, String name, Double price, Integer amount, Date createdDate, String storeId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.createdDate = createdDate;
        this.storeId = storeId;
    }

    public Cargo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }
}
