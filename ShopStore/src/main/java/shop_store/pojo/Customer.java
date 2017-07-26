package shop_store.pojo;

/**
 * Created by CHENCO7 on 7/26/2017.
 */
public class Customer {
    private String id;
    private String name;
    private String password;

    public Customer() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
