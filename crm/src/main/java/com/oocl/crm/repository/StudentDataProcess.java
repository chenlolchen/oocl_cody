package com.oocl.crm.repository;

import com.oocl.crm.bean.Student;

/**
 * Created by chen on 2017/7/9.
 */
public interface StudentDataProcess {
    void addData(Student student);

    void iterateAll();

    void iterateByKey(String key, String value);

    void sortByName();

    void sortById();

    Student getDataById(int id);

    boolean exitDataID(int deleteID);

    boolean updateByDataID(int id, Student data);

    int getIdCounter();

    void setIdCounter(int id);
}
