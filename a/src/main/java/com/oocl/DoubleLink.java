package com.oocl;

import java.util.Random;

public class DoubleLink {
    private Node head;
    private Node tail;
    private int size;

    public DoubleLink() {
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, int element) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        if (index == 0)
            addFirst(element);
        else if (index == size)
            addLast(element);
        else {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            Node insert = new Node(element, temp.prev, temp);
            temp.prev.next = insert;
            temp.prev = insert;
            size++;
        }
    }

    public void addFirst(int element) {
        Node tmp = new Node(element, null, head);
        if (head != null) {
            head.prev = tmp;
        }
        head = tmp;
        if (tail == null) {
            tail = tmp;
        }
        size++;
    }

    public void addLast(int element) {
        Node tmp = new Node(element, tail, null);
        if (head == null)
            head = tmp;
        if (tail != null)
            tail.next = tmp;
        tail = tmp;
        size++;
    }

    public void set(int index, int element){
        if(index<0 || index>=size)
            throw new IndexOutOfBoundsException();
        else{
            Node temp = head;
            for(int i=0; i<index; i++){
                temp = temp.next;
            }
            temp.element = element;
        }
    }

    public String iterateForward() {
        Node temp = head;
        StringBuilder s = new StringBuilder();
        while (temp != null) {
            s.append(temp.element + " ");
            temp = temp.next;
        }
        return s.toString();
    }

    public void sort1() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (get(j) > get(j + 1)) {
                    int temp = get(j);
                    remove(j);
                    add(j+1, temp);
                }
            }
        }
    }

    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (get(j) > get(j + 1)) {
                    int temp = get(j);
                    int temp2 = get(j + 1);
                    set(j, temp2);
                    set(j + 1, temp);
                }
            }
        }
    }

    public int binarySearch(int target){
        int left = 0;
        int right = size - 1;

        while (left <= right){
            int mid = (right + left) / 2;
            if(target == get(mid)){
                return get(mid);
            }else if(target > get(mid)){
                left = mid + 1;
            }else if (target < get(mid)){
                right = mid - 1;
            }else {
                return -1;
            }
        }
        return -1;
    }

    public int remove(int index) {
        int element = 0;
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        if (index == 0)
            removeFirst();
        else if (index == size - 1)
            removeLast();
        else {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            element = temp.element;
            temp.next.prev = temp.prev;
            temp.prev.next = temp.next;
            temp.next = null;
            temp.prev = null;
            size--;
        }
        return element;
    }

    public int removeFirst() {
        if (head == null)
            throw new NullPointerException();
        int element = head.element;
        head = head.next;
        if (head == null)
            tail = null;
        else
            head.prev = null;
        size--;
        return element;
    }

    public int removeLast() {
        if (tail == null)
            throw new NullPointerException();
        int element = tail.element;
        tail = tail.prev;
        if (tail == null)
            head = null;
        else
            tail.next = null;
        size--;
        return element;
    }

    public int get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        else {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp.element;
        }
    }

    public Node getNode(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        else {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        }
    }

    public static void main(String[] args) {
        DoubleLink dlink = new DoubleLink();

        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            dlink.add(i, random.nextInt(500));
        }
        dlink.addFirst(1111);
        dlink.addFirst(66);

        System.out.println("刪除前：");
        System.out.println(dlink.iterateForward());
        dlink.remove(0);
        System.out.println("刪除后：");
        System.out.println(dlink.iterateForward());


        System.out.println("排序前：");
        System.out.println(dlink.iterateForward());
        dlink.sort();
        System.out.println("排序后：");
        System.out.println(dlink.iterateForward());

        int number = 1111;
        System.out.println("查找元素:" + number);
        if(dlink.binarySearch(number) > 0){
            System.out.println("元素存在！");
        }else {
            System.out.println("元素不存在！");
        }
    }
}
