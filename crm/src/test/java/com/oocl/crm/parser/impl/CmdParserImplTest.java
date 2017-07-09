package com.oocl.crm.parser.impl;

import com.oocl.crm.bean.Student;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by chen on 2017/7/9.
 */
public class CmdParserImplTest {
    public static CmdParserImpl cmdParser;

    @BeforeClass
    public static void init(){
        cmdParser = new CmdParserImpl();
    }

    @Test
    public void showData() throws Exception {
        cmdParser.showData("L");
    }

    @Test
    public void addData() throws Exception {
        cmdParser.addData("name:kkk");
        Student student = cmdParser.getStudentDataProcess().getDataById(11);
        Assert.assertEquals(student.getName(),"kkk");
    }

    @Test
    public void deleteData() throws Exception {
        cmdParser.deleteData("2");
        Student student = cmdParser.getStudentDataProcess().getDataById(2);
        Assert.assertEquals(student,null);
    }

    @Test
    public void updateData() throws Exception {
        cmdParser.updateData("5 name:ppp");
        Student student = cmdParser.getStudentDataProcess().getDataById(5);
        Assert.assertEquals(student.getName(), "ppp");
    }

    @Test
    public void sortData() throws Exception {
        cmdParser.sortData("name");
        System.out.println("================================");
        cmdParser.sortData("id");
    }

}