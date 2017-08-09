package pojo;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by CHENCO7 on 8/9/2017.
 */
@Entity
public class Teacher {
    @Id
    private String tId;
    private String name;

//    targetEntity = Student.class 指定对象类型
    @OneToMany(targetEntity = Student.class)
//    @JoinTable(name = "tt") // 可以指定使用什么表来做关联， 默认不加JoinTable和JoinColumn 的情况是student_teacher表
    @JoinColumn(name = "aaa") // 这个操作会在Student上生成aaa的column从而不会生成关联表
    private Set<Student> studentSet;

    public Teacher() {
    }

    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<Student> student) {
        this.studentSet = student;
    }

    public Teacher(String tId, String name) {
        this.tId = tId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }
}
