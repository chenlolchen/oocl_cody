package com.oocl.crm.bean;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class DoubleLinkTest {
    public static DoubleLink doubleLink;

    @BeforeClass
    public static void init(){
        doubleLink = new DoubleLink();
        doubleLink.add(0, new Student(1, "小明", "男", "1994-06-03", "珠海", "13631232200"));
        doubleLink.add(1, new Student(2, "小红", "女", "1995-01-02", "珠海", "13631232231"));
        doubleLink.add(2, new Student(3, "小兰", "女", "1994-04-03", "珠海", "13631232231"));
        doubleLink.add(3, new Student(4, "小张", "男", "1994-06-08", "珠海", "13631232231"));
        doubleLink.add(4, new Student(5, "阿甘", "男", "1994-12-13", "珠海", "13631232231"));
        doubleLink.add(5, new Student(6, "小白", "女", "1994-10-24", "珠海", "13631232231"));
        doubleLink.add(6, new Student(7, "张三", "男", "1994-06-14", "珠海", "13631232231"));
        doubleLink.add(7, new Student(8, "李四", "男", "1994-08-02", "珠海", "13631232231"));
        doubleLink.add(8, new Student(9, "王五", "男", "1994-06-26", "珠海", "13631232231"));
        doubleLink.add(9, new Student(10, "老王", "男", "1994-06-07", "珠海", "13631232231"));
    }

    @Test
    public void testSize() throws Exception {
        Assert.assertEquals(doubleLink.size(),10);
    }

    @Test
    public void testIsEmpty() throws Exception {
        Assert.assertFalse(doubleLink.isEmpty());
    }

    @Test
    public void testAdd() throws Exception {
        doubleLink.add(1, new Student(11, "老王", "男", "1994-06-07", "珠海", "13631232231"));
        Assert.assertEquals(doubleLink.size(),11);
    }

    @Test
    public void testAddFirst() throws Exception {
        doubleLink.addFirst(new Student(11, "老王", "男", "1994-06-07", "珠海", "13631232231"));
        Assert.assertEquals(doubleLink.size(),11);
    }

    @Test
    public void testAddLast() throws Exception {
        doubleLink.addLast(new Student(11, "老王", "男", "1994-06-07", "珠海", "13631232231"));
        Assert.assertEquals(doubleLink.size(),11);
        doubleLink.addLast(new Student(11, "老王", "男", "1994-06-07", "珠海", "13631232231"));
        Assert.assertEquals(doubleLink.size(),11);
    }

    @Test
    public void testIterateAll() throws Exception {
        doubleLink.iterateAll();
    }

    @Test
    public void testSet() throws Exception {
        doubleLink.set(0, new Student());
        Student student = (Student) doubleLink.get(0);
        Assert.assertTrue(student.getName() == null);
    }

    @Test
    public void testRemove() throws Exception {
        Student student = (Student) doubleLink.get(0);
        doubleLink.remove(0);
        Student student2 = (Student) doubleLink.get(0);
        Assert.assertNotEquals(student.getName(),student2.getName());
    }

    @Test
    public void testRemoveFirst() throws Exception {
        Student student = (Student) doubleLink.get(0);
        doubleLink.removeFirst();
        Student student2 = (Student) doubleLink.get(0);
        Assert.assertNotEquals(student.getName(),student2.getName());
    }

    @Test
    public void testRemoveLast() throws Exception {
        Student student = (Student) doubleLink.get(0);
        doubleLink.removeLast();
        Student student2 = (Student) doubleLink.get(0);
        Assert.assertNotEquals(student.getName(),student2.getName());
    }

    @Test
    public void testGet() throws Exception {
        Student student = (Student) doubleLink.get(0);
        Assert.assertEquals(student.getName(),"小明");
    }

    @Test
    public void testIterateByKey() throws Exception {
        doubleLink.iterateByKey("name","小明");
    }

    @Test
    public void testSortByName() throws Exception {
        doubleLink.sortByName();
    }

    @Test
    public void testSortById() throws Exception {
        doubleLink.sortById();
    }

    @Test
    public void testGetDataById() throws Exception {
        Student student = (Student) doubleLink.getDataById(5);
        Assert.assertEquals(student.getName(), "阿甘");
    }

    @Test
    public void testExitDataID() throws Exception {
        Assert.assertTrue(doubleLink.exitDataID(5));
    }

    @Test
    public void testUpdateByDataID() throws Exception {
        Student student = new Student();
        student.setName("测试人物");
        student.setId(3);
        doubleLink.updateByDataID(3, student);
        Student student1 = (Student) doubleLink.getDataById(3);
        Assert.assertEquals(student.getName(), student1.getName());
    }

}