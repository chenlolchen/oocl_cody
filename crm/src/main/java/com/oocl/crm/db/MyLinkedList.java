package com.oocl.crm.db;

public class MyLinkedList<T> {
    public Node<T> head;
    public Node<T> tail;
    public int size;

    public class Node<T extends Object> {
        public Node<T> prev;
        public Node<T> next;
        public T data;

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

    public MyLinkedList() {
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

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

    public void addLast(T element) {
        Node tmp = new Node<T>(element, tail, null);
        if (head == null)
            head = tmp;
        if (tail != null)
            tail.next = tmp;
        tail = tmp;
        size++;
    }

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
}
