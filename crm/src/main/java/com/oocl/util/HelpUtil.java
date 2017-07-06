package com.oocl.util;

import com.oocl.DoubleLink;
import com.oocl.Student;

public class HelpUtil {
    private DoubleLink doubleLink;
    private int idCounter;

    public HelpUtil(DoubleLink doubleLink) {
        this.doubleLink = doubleLink;
        this.idCounter = doubleLink.size();
    }

    public static void showHelp(){
        System.out.println("================================================");
        System.out.println("== 1. 输入L查看数据（参数：id,name,sex,birthday,address,call） ===");
        System.out.println("== 2. 输入A添加数据（参数：name,sex,birthday,address,call） ===");
        System.out.println("== 3. 输入D删除数据（参数：ID） ===");
        System.out.println("== 4. 输入U修改数据（参数：id,name,sex,birthday,address,call） ===");
        System.out.println("== 5. 输入O对数据进行排序（参数：id/name） ===");
        System.out.println("== 6. 输入H查看帮助 ===");
        System.out.println("== 7. 输入Q查看帮助 ===");
        System.out.println("================================================");
    }

    public void handleInput(String inputStr){
        if(inputStr.equals("")){
            return;
        }
        switch (inputStr.charAt(0)){
            case 'L':
                System.out.println("into L");
                doubleLink.iterateForward();
                break;
            case 'A':
                System.out.println("into A");
                if(inputStr.length() > 2){
                    Student student = new Student();
                    String str = inputStr.substring(2, inputStr.length());
                    String[] strSplit = str.split(",");
                    for(String ss : strSplit){
                        String[] s = ss.split(":");
                        if (s[0].equals("name")){
                            student.setName(s[1]);
                        }else if(s[0].equals("sex")){
                            student.setSex(s[1]);
                        }else if(s[0].equals("birthDay")){
                            student.setBirthDay(s[1]);
                        }else if(s[0].equals("address")){
                            student.setAddress(s[1]);
                        }else if(s[0].equals("call")){
                            student.setCall(s[1]);
                        }else {
                            return;
                        }
                    }
                    student.setId(++idCounter);
                    doubleLink.addLast(student);
                }
                break;
            case 'D':
                System.out.println("into D");

                int deleteID = Integer.parseInt(inputStr.substring(2, inputStr.length())) - 1;
                if(deleteID > 0 && deleteID < idCounter){
                    doubleLink.remove(deleteID);
                }
                break;
            case 'U':
                System.out.println("into U");
                int editID = Integer.parseInt(inputStr.substring(2, 3)) - 1;
                String paramStr = inputStr.substring(4, inputStr.length());
                String[] splitParams = paramStr.split(",");


                Student student = (Student) doubleLink.get(editID);

                for(String ss : splitParams){
                    String[] s = ss.split(":");
                    if (s[0].equals("name")){
                        student.setName(s[1]);
                    }else if(s[0].equals("sex")){
                        student.setSex(s[1]);
                    }else if(s[0].equals("birthDay")){
                        student.setBirthDay(s[1]);
                    }else if(s[0].equals("address")){
                        student.setAddress(s[1]);
                    }else if(s[0].equals("call")){
                        student.setCall(s[1]);
                    }
                }
                doubleLink.set(editID,student);
                break;
            case 'O':
                System.out.println("into O");
                String sortString = inputStr.substring(2, inputStr.length());
                if(sortString.equals("name")){
                    doubleLink.sortByName();
                }else if (sortString.equals("id")){
                    doubleLink.sortById();
                }else {
                    return;
                }
                break;
            case 'H':
                showHelp();
                break;
            default:
                System.out.println("usage H for Looking Help...");
        }
    }
}
