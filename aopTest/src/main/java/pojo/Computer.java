package pojo;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by CHENCO7 on 8/9/2017.
 */
@Entity
public class Computer {
    @Id
    private String id;
    private String computerName;
    @ManyToMany(mappedBy = "computerSet")
    private Set<People> peopleSet;

    public Set<People> getPeopleSet() {
        return peopleSet;
    }

    public void setPeopleSet(Set<People> peopleSet) {
        this.peopleSet = peopleSet;
    }

    public Computer() {
    }

    public Computer(String id, String computerName) {
        this.id = id;
        this.computerName = computerName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }
}
