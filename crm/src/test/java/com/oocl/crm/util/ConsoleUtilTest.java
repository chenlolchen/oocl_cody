package com.oocl.crm.util;

import com.oocl.crm.bean.DoubleLink;
import com.oocl.crm.bean.Student;
import org.junit.BeforeClass;
import org.junit.Test;

public class ConsoleUtilTest {
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
    public void showHelp() throws Exception {
        consoleUtil.showHelp("H");
    }

    @Test
    public void handleInput() throws Exception {
        consoleUtil.handleInput("L");
        consoleUtil.handleInput("L name:小红");
        consoleUtil.handleInput("LLname:小红");
        consoleUtil.handleInput("O name");
        consoleUtil.handleInput("O id");
        consoleUtil.handleInput("D 3");
        consoleUtil.handleInput("D 4");
        consoleUtil.handleInput("D 3");
        consoleUtil.handleInput("A name:kkk");
        consoleUtil.handleInput("A name:ooo,sex:男");
        consoleUtil.handleInput("U 2 name:edit");
        consoleUtil.handleInput("U 200 name:edit");
        consoleUtil.handleInput("U 3 name:test,sex:男生");
        consoleUtil.handleInput("H");
    }

}