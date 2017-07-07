package com.oocl.crm.util;

import com.oocl.crm.bean.DoubleLink;
import com.oocl.crm.bean.Student;
import com.oocl.crm.exception.FormatException;

public class DataUtil {
    private DoubleLink doubleLink;
    private int idCounter;
    private String inputParamsString;

    public DataUtil(DoubleLink doubleLink) {
        this.doubleLink = doubleLink;
        this.idCounter = doubleLink.size();
    }

    public String getInputParamsString() {
        return inputParamsString;
    }

    public void setInputParamsString(String inputParamsString) {
        this.inputParamsString = inputParamsString;
    }

    public void showData() {
        //inputParamsString: L / name:xxx / sex:xxx
        if (inputParamsString.trim().equals("L")) {
            doubleLink.iterateAll();
        } else {
            String[] searchItem = inputParamsString.trim().split(":");
            String key = searchItem[0];
            String value = searchItem[1];
            doubleLink.iterateByKey(key, value);
        }
    }

    public void addData() {
        //inputParamsString: name:xxx,sex:xxx
        String[] paramsStringList = inputParamsString.trim().split(",");
        Student student = new Student();
        setParamsToStudent(student, paramsStringList);
        student.setId(++idCounter);
        doubleLink.addLast(student);
    }

    public void deleteData() {
        //inputParamsString: id
        int deleteID = Integer.parseInt(inputParamsString.trim());
        if (deleteID > 0 && deleteID <= idCounter) {
            if (doubleLink.exitDataID(deleteID)) {
                System.out.println("success delete");
            } else {
                System.out.println("your input id is not exit");
            }
        } else {
            System.out.println("please input id between 0 - " + idCounter);
        }
    }

    public void updateData() {
        //inputParamsString: id name:xxx
        String[] updateParamsSplit = inputParamsString.split(" ");
        int editID = Integer.parseInt(updateParamsSplit[0]);
        String[] paramsStringList = updateParamsSplit[1].trim().split(",");
        Student student = (Student) doubleLink.getDataById(editID);
        if(student != null){
            setParamsToStudent(student, paramsStringList);
            if (editID > 0 && editID <= idCounter) {
                if (doubleLink.updateByDataID(editID, student)) {
                    System.out.println("update success");
                } else {
                    System.out.println("your input id is not exit");
                }
            } else {
                System.out.println("please check your input id between 0 - " + idCounter);
            }
        }else {
            System.out.println("can not found student id");
        }
    }

    public void sortData() {
        //inputParamsString: id/name
        String sortString = inputParamsString.trim();
        if (sortString.equals("name")) {
            doubleLink.sortByName();
        } else if (sortString.equals("id")) {
            doubleLink.sortById();
        } else {
            System.out.println("please input a name or id");
        }
    }

    private void setParamsToStudent(Student student, String[] paramsStringList) {
        for (String item : paramsStringList) {
            String[] s = item.split(":");
            String key = s[0];
            String value = s[1];
            switch (key) {
                case "name":
                    student.setName(value);
                    break;
                case "sex":
                    student.setSex(value);
                    break;
                case "birthDay":
                    student.setBirthDay(value);
                    break;
                case "address":
                    student.setAddress(value);
                    break;
                case "call":
                    student.setCall(value);
                    break;
                default:
                    throw new FormatException();
            }
        }
    }
}
