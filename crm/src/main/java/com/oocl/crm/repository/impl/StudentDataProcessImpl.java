package com.oocl.crm.repository.impl;

import com.oocl.crm.bean.Student;
import com.oocl.crm.db.MyLinkedList;
import com.oocl.crm.db.MyLinkedListFactory;
import com.oocl.crm.exception.FormatException;
import com.oocl.crm.repository.StudentDataProcess;

/**
 * Created by chen on 2017/7/9.
 */
public class StudentDataProcessImpl implements StudentDataProcess {
    MyLinkedList<Student> myLinkedList;
    private int idCounter;

    public StudentDataProcessImpl(){
        myLinkedList = MyLinkedListFactory.getInstance();
        idCounter = myLinkedList.size() + 1;
    }

    public MyLinkedList<Student> getMyLinkedList() {
        return myLinkedList;
    }

    public int getIdCounter() {
        return idCounter;
    }

    public void setIdCounter(int idCounter) {
        this.idCounter = idCounter;
    }

    public void setMyLinkedList(MyLinkedList<Student> myLinkedList) {
        this.myLinkedList = myLinkedList;
    }

    @Override
    public void iterateAll() {
        MyLinkedList.Node temp = myLinkedList.head;
        while (temp != null) {
            System.out.println(temp.getData().toString());
            temp = temp.next;
        }
    }

    @Override
    public void iterateByKey(String key, String value) {
        MyLinkedList.Node temp = myLinkedList.head;
        for (int i = 0; i < myLinkedList.size; i++) {
            Student student = (Student) temp.getData();
            switch (key) {
                case "id":
                    if (student.getId() == (Integer.parseInt(value))) {
                        System.out.println(temp.getData().toString());
                    }
                    break;
                case "name":
                    if (student.getName().equals(value)) {
                        System.out.println(temp.getData().toString());
                    }
                    break;
                case "sex":
                    if (student.getSex().equals(value)) {
                        System.out.println(temp.getData().toString());
                    }
                    break;
                case "birthDay":
                    if (student.getBirthDay().equals(value)) {
                        System.out.println(temp.getData().toString());
                    }
                    break;
                case "address":
                    if (student.getAddress().equals(value)) {
                        System.out.println(temp.getData().toString());
                    }
                    break;
                case "call":
                    if (student.getCall().equals(value)) {
                        System.out.println(temp.getData().toString());
                    }
                    break;
                default:
                    throw new FormatException();
            }
            temp = temp.next;
        }
    }

    @Override
    public void addData(Student student) {
        myLinkedList.addLast(student);
    }

    @Override
    public void sortByName() {
        int[] outPutQueue = new int[myLinkedList.size];
        for(int m = 0; m < myLinkedList.size; m++){
            outPutQueue[m] = m;
        }
        for (int i = 0; i < myLinkedList.size - 1; i++) {
            for (int j = 0; j < myLinkedList.size - 1 - i; j++) {
                Student s1 = myLinkedList.get(outPutQueue[j]);
                Student s2 = myLinkedList.get(outPutQueue[j + 1]);
                if ((s2.getName()).compareTo(s1.getName()) > 0) {
                    int temp = outPutQueue[j + 1];
                    outPutQueue[j + 1] = outPutQueue[j];
                    outPutQueue[j] = temp;
                }
            }
        }

        for(int n = 0; n < myLinkedList.size; n++){
            System.out.println(myLinkedList.get(outPutQueue[n]));
        }
    }

    @Override
    public void sortById() {
        int[] outPutQueue = new int[myLinkedList.size];
        for(int m = 0; m < myLinkedList.size; m++){
            outPutQueue[m] = m;
        }

        for (int i = 0; i < myLinkedList.size - 1; i++) {
            for (int j = 0; j < myLinkedList.size - 1 - i; j++) {
                Student s1 = myLinkedList.get(outPutQueue[j]);
                Student s2 = myLinkedList.get(outPutQueue[j + 1]);
                if (s1.getId() > s2.getId()) {
                    int temp = outPutQueue[j + 1];
                    outPutQueue[j + 1] = outPutQueue[j];
                    outPutQueue[j] = temp;
                }
            }
        }

        for(int n = 0; n < myLinkedList.size; n++){
            System.out.println(myLinkedList.get(outPutQueue[n]));
        }
    }

    @Override
    public Student getDataById(int id) {
        MyLinkedList.Node temp = myLinkedList.head;
        for (int i = 0; i < myLinkedList.size; i++) {
            Student stu = (Student) temp.getData();
            if (stu.getId() == id) {
                return stu;
            }
            temp = temp.next;
        }
        return null;
    }

    @Override
    public boolean exitDataID(int deleteID) {
        boolean result = false;
        int index = 0;

        MyLinkedList.Node temp = myLinkedList.head;
        for (int i = 0; i < myLinkedList.size; i++) {
            Student stu = (Student) temp.getData();
            if (stu.getId() == deleteID) {
                result = true;
                myLinkedList.remove(index);
                break;
            }
            index++;
            temp = temp.next;
        }
        return result;
    }

    @Override
    public boolean updateByDataID(int id, Student data) {
        boolean result = false;
        int index = 0;
        MyLinkedList.Node temp = myLinkedList.head;
        for (int i = 0; i < myLinkedList.size; i++) {
            Student stu = (Student) temp.getData();
            if (stu.getId() == id) {
                result = true;
                myLinkedList.set(index, data);
                break;
            }
            index++;
            temp = temp.next;
        }
        return result;
    }
}
