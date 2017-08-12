package pojo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by CHENCO7 on 8/11/2017.
 */
@Embeddable
public class Address {
    private String name;

    @Column(columnDefinition = "char(2)")
    private Boolean defaultAddress;

    public Address() {
    }

    public Address(String name) {
        this.name = name;
    }

    public Address(String name, Boolean defaultAddress) {
        this.name = name;
        this.defaultAddress = defaultAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getDefaultAddress() {
        return defaultAddress;
    }

    public void setDefaultAddress(Boolean defaultAddress) {
        this.defaultAddress = defaultAddress;
    }

    @Override
    public String toString() {
        return "Address{" +
                "name='" + name + '\'' +
                ", defaultAddress=" + defaultAddress +
                '}';
    }
}
