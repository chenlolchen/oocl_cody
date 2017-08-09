package dao.impl;

import dao.UserDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import pojo.*;
import util.MD5Util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Created by CHENCO7 on 8/9/2017.
 */
public class UserDaoImplTest {
    private UserDao userDao;
    private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Before
    public void setUp(){
        userDao = context.getBean(UserDao.class);
    }

    @Test
    public void register() throws Exception {
        User user = new User(UUID.randomUUID().toString(), "chen555", MD5Util.getMD5("ooo"), 23);
        Assert.assertTrue(userDao.register(user));
    }

    @Test
    public void login() throws Exception {
        User user = userDao.login("chen", MD5Util.getMD5("ooo"));
        System.out.println(user);
    }

    @Test
    public void testOneToOne() throws Exception {
        EntityManagerFactory factory = context.getBean("ss",EntityManagerFactory.class);
        EntityManager manager = factory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();

        Customer customer = new Customer(UUID.randomUUID().toString(), "customer", 53);
        Book book = new Book(UUID.randomUUID().toString(), "book");
        customer.setBook(book);

        tx.begin();
        manager.persist(book);
        manager.persist(customer);
        tx.commit();
    }

    @Test
    public void testOneToOneTwoWay() throws Exception {
        EntityManagerFactory factory = context.getBean("ss",EntityManagerFactory.class);
        EntityManager manager = factory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();

        Customer customer = new Customer(UUID.randomUUID().toString(), "customer", 53);
        Book book = new Book(UUID.randomUUID().toString(), "book");
        customer.setBook(book);
        book.setCustomer(customer);

        tx.begin();
        manager.persist(book);
        manager.persist(customer);
        tx.commit();
    }

    @Test
    public void testOneToMany() throws Exception {
        EntityManagerFactory factory = context.getBean("ss",EntityManagerFactory.class);
        EntityManager manager = factory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();

        Student s1 = new Student(UUID.randomUUID().toString(), "chen");
        Student s2 = new Student(UUID.randomUUID().toString(), "zhang");
        Teacher teacher = new Teacher(UUID.randomUUID().toString(), "ttt");
        Teacher teacher1 = new Teacher(UUID.randomUUID().toString(), "ttt222");
        Set<Student> set = new HashSet<Student>();
        set.add(s1);
        set.add(s2);
        Set<Student> set2 = new HashSet<Student>();
        set2.add(s1);

        teacher1.setStudentSet(set2);
        teacher.setStudentSet(set);

        tx.begin();
        manager.persist(s1);
        manager.persist(s2);
        manager.persist(teacher);
        tx.commit();
    }

    @Test
    public void testManyToOne() throws Exception {
        EntityManagerFactory factory = context.getBean("ss",EntityManagerFactory.class);
        EntityManager manager = factory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();

        Student s1 = new Student(UUID.randomUUID().toString(), "chen");
        Student s2 = new Student(UUID.randomUUID().toString(), "zhang");
        Teacher teacher = new Teacher(UUID.randomUUID().toString(), "ttt");

        s1.setTeacher(teacher);
        s2.setTeacher(teacher);

        tx.begin();
        manager.persist(s1);
        manager.persist(s2);
        manager.persist(teacher);
        tx.commit();
    }

    @Test
    public void testManyToMany() throws Exception {
        EntityManagerFactory factory = context.getBean("ss",EntityManagerFactory.class);
        EntityManager manager = factory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();

        Computer c1 = new Computer(UUID.randomUUID().toString(), "com1");
        Computer c2 = new Computer(UUID.randomUUID().toString(), "com2333");
        Computer c3 = new Computer(UUID.randomUUID().toString(), "com6666");

        People p1 = new People(UUID.randomUUID().toString(), "peo1");
        People p2 = new People(UUID.randomUUID().toString(), "peo25325");

        Set<Computer> set = new HashSet<Computer>();
        Set<Computer> set2 = new HashSet<Computer>();
        Set<Computer> set3 = new HashSet<Computer>();

        set.add(c1);
        set.add(c2);
        set.add(c3);

        set2.add(c2);

        set3.add(c3);

        p1.setComputerSet(set);
        p2.setComputerSet(set2);

//        Set<People> set = new HashSet<People>();
//        Set<People> set2 = new HashSet<People>();
//
//        set.add(p1);
//        set.add(p2);
//
//        set2.add(p2);
//
//        c1.setPeopleSet(set);
//        c2.setPeopleSet(set2);
//        c3.setPeopleSet(set);


        tx.begin();
        manager.persist(c1);
        manager.persist(c2);
        manager.persist(c3);
        manager.persist(p1);
        manager.persist(p2);
        tx.commit();
    }


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

}