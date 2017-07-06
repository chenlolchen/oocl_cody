package com.oocl;

public class Node {
    int element;
    Node next;
    Node prev;

    public Node(int element, Node prev, Node next) {
        this.element = element;
        this.prev = prev;
        this.next = next;
    }

    public Node(int element) {
        this(element, null, null);
    }
}
