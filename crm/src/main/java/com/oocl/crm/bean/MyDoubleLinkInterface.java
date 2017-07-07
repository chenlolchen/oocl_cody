package com.oocl.crm.bean;

public interface MyDoubleLinkInterface<T> {
    void iterateByKey(String key, String value);

    void sortByName();

    void sortById();

    T getDataById(int id);

    boolean exitDataID(int deleteID);

    boolean updateByDataID(int id, T data);
}
