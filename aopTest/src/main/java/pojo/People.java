package pojo;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by CHENCO7 on 8/9/2017.
 */
@Entity
public class People {
    @Id
    private String id;
    private String name;
    @ManyToMany
    @JoinTable(name = "p_c",
            joinColumns = {@JoinColumn(name = "p_id")},
            inverseJoinColumns = {@JoinColumn(name = "c_id")}
    )
    private Set<Computer> computerSet;

    public Set<Computer> getComputerSet() {
        return computerSet;
    }

    public void setComputerSet(Set<Computer> computerSet) {
        this.computerSet = computerSet;
    }

    public People() {
    }

    public People(String id, String name) {
        this.id = id;
        this.name = name;
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
