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
    private Boolean isDefaultAddress;

    public Address() {
    }

    public Address(String name) {
        this.name = name;
    }

    public Address(String name, Boolean isDefaultAddress) {
        this.name = name;
        this.isDefaultAddress = isDefaultAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsDefaultAddress() {
        return isDefaultAddress;
    }

    public void setIsDefaultAddress(Boolean defaultAddress) {
        this.isDefaultAddress = defaultAddress;
    }

    @Override
    public String toString() {
        return "Address{" +
                "name='" + name + '\'' +
                ", defaultAddress=" + isDefaultAddress +
                '}';
    }
}
