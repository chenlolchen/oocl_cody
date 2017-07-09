package com.oocl.crm.db;


import com.oocl.crm.bean.Student;

public class MyLinkedListFactory {
	private static MyLinkedList<Student> myLinkedList;

	public static MyLinkedList<Student> getInstance(){
		myLinkedList = new MyLinkedList<Student>();
		myLinkedList.add(0, new Student(1, "小明", "男", "1994-06-03", "珠海", "13631232200"));
		myLinkedList.add(1,  new Student(2, "小红", "女", "1995-01-02", "珠海", "13631232231"));
		myLinkedList.add(2, new Student(3, "小兰", "女", "1994-04-03", "珠海", "13631232231"));
		myLinkedList.add(3, new Student(4, "小张", "男", "1994-06-08", "广州", "13631232231"));
		myLinkedList.add(4, new Student(5, "阿甘", "男", "1994-12-13", "珠海", "13631232231"));
		myLinkedList.add(5, new Student(6, "小白", "女", "1994-10-24", "广州", "13631232231"));
		myLinkedList.add(6, new Student(7, "张三", "男", "1994-06-14", "珠海", "13631232231"));
		myLinkedList.add(7, new Student(8, "李四", "男", "1994-08-02", "珠海", "13631232231"));
		myLinkedList.add(8, new Student(9, "王五", "男", "1994-06-26", "珠海", "13631232231"));
		myLinkedList.add(9, new Student(10, "老王", "男", "1994-06-07", "珠海", "13631232231"));
		return myLinkedList;
	}
}
