package com.oocl.crm.bean;

import com.oocl.crm.base.DoubleLinkBase;
import com.oocl.crm.exception.FormatException;

public class DoubleLink<T> extends DoubleLinkBase<T> implements MyDoubleLinkInterface<T>{
    public void initData(){
        add(0, (T) new Student(1, "小明", "男", "1994-06-03", "珠海", "13631232200"));
        add(1, (T) new Student(2, "小红", "女", "1995-01-02", "珠海", "13631232231"));
        add(2, (T) new Student(3, "小兰", "女", "1994-04-03", "珠海", "13631232231"));
        add(3, (T) new Student(4, "小张", "男", "1994-06-08", "广州", "13631232231"));
        add(4, (T) new Student(5, "阿甘", "男", "1994-12-13", "珠海", "13631232231"));
        add(5, (T) new Student(6, "小白", "女", "1994-10-24", "广州", "13631232231"));
        add(6, (T) new Student(7, "张三", "男", "1994-06-14", "珠海", "13631232231"));
        add(7, (T) new Student(8, "李四", "男", "1994-08-02", "珠海", "13631232231"));
        add(8, (T) new Student(9, "王五", "男", "1994-06-26", "珠海", "13631232231"));
        add(9, (T) new Student(10, "老王", "男", "1994-06-07", "珠海", "13631232231"));
    }

    public void sortByName() {
        int[] outPutQueue = new int[size];
        for(int m = 0; m < size; m++){
            outPutQueue[m] = m;
        }
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                Student s1 = (Student) get(outPutQueue[j]);
                Student s2 = (Student) get(outPutQueue[j + 1]);
                if ((s2.getName()).compareTo(s1.getName()) > 0) {
                    int temp = outPutQueue[j + 1];
                    outPutQueue[j + 1] = outPutQueue[j];
                    outPutQueue[j] = temp;
                }
            }
        }

        for(int n = 0; n < size; n++){
            System.out.println(get(outPutQueue[n]));
        }
    }

    public void sortById() {
        int[] outPutQueue = new int[size];
        for(int m = 0; m < size; m++){
            outPutQueue[m] = m;
        }

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                Student s1 = (Student) get(outPutQueue[j]);
                Student s2 = (Student) get(outPutQueue[j + 1]);
                if (s1.getId() > s2.getId()) {
                    int temp = outPutQueue[j + 1];
                    outPutQueue[j + 1] = outPutQueue[j];
                    outPutQueue[j] = temp;
                }
            }
        }

        for(int n = 0; n < size; n++){
            System.out.println(get(outPutQueue[n]));
        }
    }

    public T getDataById(int id){
        Node<T> temp = head;
        for (int i = 0; i < size; i++) {
            Student stu = (Student) temp.getData();
            if (stu.getId() == id) {
                return (T) stu;
            }
            temp = temp.next;
        }
        return null;
    }

    public boolean exitDataID(int deleteID) {
        boolean result = false;
        int index = 0;

        Node<T> temp = head;
        for (int i = 0; i < size; i++) {
            Student stu = (Student) temp.getData();
            if (stu.getId() == deleteID) {
                result = true;
                remove(index);
                break;
            }
            index++;
            temp = temp.next;
        }
        return result;

    }

    public boolean updateByDataID(int id, T data) {
        boolean result = false;
        int index = 0;
        Node<T> temp = head;
        for (int i = 0; i < size; i++) {
            Student stu = (Student) temp.getData();
            if (stu.getId() == id) {
                result = true;
                set(index, data);
                break;
            }
            index++;
            temp = temp.next;
        }
        return result;
    }

    public void iterateByKey(String key, String value) {
        Node<T> temp = head;
        for (int i = 0; i < size; i++) {
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
}
