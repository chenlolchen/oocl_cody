package pojo;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by CHENCO7 on 8/9/2017.
 */
@Entity
public class Student {
    @Id
    private String id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "ccc")
    private Teacher teacher;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student() {
    }

    public Student(String id, String name) {
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
