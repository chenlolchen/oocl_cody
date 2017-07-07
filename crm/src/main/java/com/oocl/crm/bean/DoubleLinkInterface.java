package com.oocl.crm.bean;

/**
 * Created by CHENCO7 on 7/7/2017.
 */
public interface DoubleLinkInterface<T> {
    void add(int index, T data);

    void addFirst(T element);

    void addLast(T element);

    void iterateAll();

    void set(int index, T element);

    T remove(int index);

    T removeFirst();

    T removeLast();

    T get(int index);

}
