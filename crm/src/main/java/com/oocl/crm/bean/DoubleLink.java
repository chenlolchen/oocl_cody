package com.oocl.crm.bean;

import com.oocl.crm.exception.FormatException;
import com.oocl.crm.util.ConsoleUtil;
import com.oocl.crm.util.DataUtil;

import java.util.Scanner;

public class DoubleLink<T> implements DoubleLinkInterface<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;


    class Node<T extends Object> {
        private Node<T> prev;
        private Node<T> next;
        private T data;

        public Node(T t, Node prev, Node next) {
            this.data = t;
            this.prev = prev;
            this.next = next;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }

    public DoubleLink() {
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(int index, T data) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        if (index == 0)
            addFirst(data);
        else if (index == size)
            addLast(data);
        else {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            Node insert = new Node<T>(data, temp.prev, temp);
            temp.prev.next = insert;
            temp.prev = insert;
            size++;
        }
    }

    @Override
    public void addFirst(T element) {
        Node tmp = new Node<T>(element, null, head);
        if (head != null) {
            head.prev = tmp;
        }
        head = tmp;
        if (tail == null) {
            tail = tmp;
        }
        size++;
    }

    @Override
    public void addLast(T element) {
        Node tmp = new Node<T>(element, tail, null);
        if (head == null)
            head = tmp;
        if (tail != null)
            tail.next = tmp;
        tail = tmp;
        size++;
    }

    @Override
    public void iterateAll() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.getData().toString());
            temp = temp.next;

        }
    }

    @Override
    public void set(int index, T element) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        else {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            temp.data = element;
        }
    }

    @Override
    public T remove(int index) {
        T element = null;
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        if (index == 0)
            removeFirst();
        else if (index == size - 1)
            removeLast();
        else {
            Node<T> temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            element = temp.data;
            temp.next.prev = temp.prev;
            temp.prev.next = temp.next;
            temp.next = null;
            temp.prev = null;
            size--;
        }
        return element;
    }

    @Override
    public T removeFirst() {
        if (head == null)
            throw new NullPointerException();
        T element = head.data;
        head = head.next;
        if (head == null)
            tail = null;
        else
            head.prev = null;
        size--;
        return element;
    }

    @Override
    public T removeLast() {
        if (tail == null)
            throw new NullPointerException();
        T element = tail.data;
        tail = tail.prev;
        if (tail == null)
            head = null;
        else
            tail.next = null;
        size--;
        return element;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        else {
            Node<T> temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp.data;
        }
    }

    public void iterateByKey(String key, String value) {
        Node<T> temp = head;
        for (int i = 0; i < size; i++) {
            Student student = (Student) temp.getData();
            switch (key) {
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

//    public void sortById() {
//        for (int i = 0; i < size - 1; i++) {
//            for (int j = 0; j < size - 1 - i; j++) {
//                Student s1 = (Student) get(j);
//                Student s2 = (Student) get(j + 1);
//                if (s1.getId() > s2.getId()) {
//                    set(j, (T) s2);
//                    set(j + 1, (T) s1);
//                }
//            }
//        }
//        iterateAll();
//    }

//    public void sortByName() {
//        for (int i = 0; i < size - 1; i++) {
//            for (int j = 0; j < size - 1 - i; j++) {
//                Student s1 = (Student) get(j);
//                Student s2 = (Student) get(j + 1);
//                if ((s2.getName()).compareTo(s1.getName()) > 0) {
//                    set(j, (T) s2);
//                    set(j + 1, (T) s1);
//                }
//            }
//        }
//        iterateAll();
//    }

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

    public static void main(String[] args) {
        DoubleLink doubleLink = new DoubleLink();
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

        DataUtil dataUtil = new DataUtil(doubleLink);
        ConsoleUtil consoleUtil = new ConsoleUtil(dataUtil);
        ConsoleUtil.showHelp();

        Scanner scanner = new Scanner(System.in);
        String input;
        input = scanner.nextLine();
        while (!(input).equals("Q")) {
            consoleUtil.handleInput(input);
            input = scanner.nextLine();
        }
        System.out.println("=============== exit ================");

    }
}
