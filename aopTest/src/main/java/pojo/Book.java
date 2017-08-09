package pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by CHENCO7 on 8/9/2017.
 */
@Entity
public class Book {
    @Id
    private String id;
    private String name;

    @OneToOne
    @JoinColumn(name = "c_id")
    private Customer customer;

    public Book() {
    }

    public Book(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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


}
