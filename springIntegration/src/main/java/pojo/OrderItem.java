package pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by CHENCO7 on 8/11/2017.
 */
@Entity
public class OrderItem {
    @Id
    @GenericGenerator(name = "uuid_generator", strategy = "uuid")
    @GeneratedValue(generator = "uuid_generator")
    private String id;
    private String name;
    private Double price;


    public OrderItem() {
    }

    public OrderItem(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public OrderItem(String id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
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
}
