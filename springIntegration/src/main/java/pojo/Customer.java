package pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by CHENCO7 on 8/11/2017.
 */
@Entity
public class Customer {
    @Id
    @GenericGenerator(name = "uuid_generator", strategy = "uuid")
    @GeneratedValue(generator = "uuid_generator")
    private String id;
    private String name;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "u_id")
    private List<Order> order = new ArrayList<Order>();

    @ElementCollection
    @JoinTable(name = "addresses", joinColumns = {@JoinColumn(name = "c_id")})
    private List<Address> addressList = new ArrayList<Address>();

    @Transient
    private String defaultAddress;

    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
    }

    public Customer(String id, String name, List<Order> order) {
        this.id = id;
        this.name = name;
        this.order = order;
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

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public String getDefaultAddress() {
        return defaultAddress;
    }

    public void setDefaultAddress(String defaultAddress) {
        this.defaultAddress = defaultAddress;
        this.updateDefaultAddress();
    }

    public void updateDefaultAddress(){
        for (Address address : addressList){
            address.setDefaultAddress(false);
        }

        for (Address address : addressList){
            System.out.println(address);
            if(address.getName().equals(getDefaultAddress())){
                address.setDefaultAddress(true);
                return;
            }
        }
    }

}
