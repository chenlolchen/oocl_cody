package com.oocl.crm.repository;

import com.oocl.crm.bean.Student;
import com.oocl.crm.repository.impl.StudentDataProcessImpl;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by chen on 2017/7/9.
 */
public class StudentDataProcessTest {
    public static StudentDataProcess studentDataProcess;

    @BeforeClass
    public static void init(){
        studentDataProcess = new StudentDataProcessImpl();
    }

    @Test
    public void addData() throws Exception {
        Student student = new Student();
        student.setName("test");
        studentDataProcess.addData(student);
    }

    @Test
    public void iterateAll() throws Exception {
        studentDataProcess.iterateAll();
    }

    @Test
    public void iterateByKey() throws Exception {
        studentDataProcess.iterateByKey("name","小红");
    }

    @Test
    public void sortByName() throws Exception {
        studentDataProcess.sortByName();
    }

    @Test
    public void sortById() throws Exception {
        studentDataProcess.sortById();
    }

    @Test
    public void getDataById() throws Exception {
        Student student = studentDataProcess.getDataById(3);
        Assert.assertEquals(student.getName(),"小兰");
    }

    @Test
    public void exitDataID() throws Exception {
        Assert.assertTrue(studentDataProcess.exitDataID(5));
        Assert.assertFalse(studentDataProcess.exitDataID(111));
    }

    @Test
    public void updateByDataID() throws Exception {
        Student student = new Student();
        student.setName("ooo");
        student.setId(2);
        studentDataProcess.updateByDataID(2,student);
        Student student2 = studentDataProcess.getDataById(2);
        Assert.assertEquals(student2.getName(), student.getName());
    }

}