package pojo;

import javax.persistence.*;

/**
 * Created by CHENCO7 on 8/9/2017.
 */
@Entity
public class Customer {
    @Id
    private String id;
    private String name;
    private Integer age;
    @OneToOne
    @JoinColumn(name = "b_id")
    private Book book;

    public Customer() {
    }
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("john");
        EntityManager manager = factory.createEntityManager();
        System.out.println(manager);
        manager.close();
        factory.close();
    }

    public Customer(String id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
