package com.oocl.crm.util;

import com.oocl.crm.bean.DoubleLink;
import com.oocl.crm.bean.Student;
import com.oocl.crm.exception.FormatException;
import org.junit.BeforeClass;
import org.junit.Test;

public class DataUtilTest {
    public static ConsoleUtil consoleUtil;
    public static DataUtil dataUtil;
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
        dataUtil = new DataUtil(doubleLink);
        consoleUtil = new ConsoleUtil(dataUtil);
    }


    @Test
    public void showData(){
        dataUtil.setInputParamsString("L");
        dataUtil.showData();
        System.out.println("==================================");
        dataUtil.setInputParamsString("name:小红");
        dataUtil.showData();
    }

    @Test
    public void sortData(){
        dataUtil.setInputParamsString("id");
        dataUtil.sortData();
        System.out.println("==================================");
        dataUtil.setInputParamsString("name");
        dataUtil.sortData();
    }

    @Test
    public void deleteData(){
        dataUtil.setInputParamsString("3");
        dataUtil.deleteData();
        consoleUtil.handleInput("L");
        System.out.println("================================");
        dataUtil.setInputParamsString("3");
        dataUtil.deleteData();
        consoleUtil.handleInput("L");
    }

    @Test
    public void addData() throws FormatException {
        dataUtil.setInputParamsString("name:abc");
        dataUtil.addData();
        consoleUtil.handleInput("L");
        System.out.println("=======================================");
        dataUtil.setInputParamsString("name:abc,sex:男,birthDay:1900,address:广州,call:123456789,xx:xxx");
        try {
            dataUtil.addData();
        }catch (FormatException ex){
            System.out.println("输入格式错误");
        }
        consoleUtil.handleInput("L");
    }

    @Test
    public void updateData(){
        dataUtil.setInputParamsString("2 name:xxx");
        dataUtil.updateData();
        consoleUtil.handleInput("L");
        System.out.println("=========================================");
        dataUtil.setInputParamsString("33 name:xxx");
        dataUtil.updateData();
        consoleUtil.handleInput("L");
    }

}
