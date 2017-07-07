package com.oocl.crm.util;

import com.oocl.crm.exception.FormatException;

import java.util.Scanner;

public class ConsoleUtil {
    private static final String ADD = "A";
    private static final String UPDATE = "U";
    private static final String DELETE = "D";
    private static final String ORDER = "O";
    private static final String SHOW = "L";
    private static final String HELP = "H";
    private static final String EXIT = "Q";

    private DataUtil dataUtil;

    public ConsoleUtil(DataUtil dataUtil) {
        this.dataUtil = dataUtil;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        String input;
        input = scanner.nextLine();
        while (!(input).equals("Q")) {
            handleInput(input);
            input = scanner.nextLine();
        }
        System.out.println("=============== exit ================");
    }

    public void showHelp(String inputStr) {
        System.out.println("===========================================================");
        if(inputStr.length() >= 2){
            switch (String.valueOf(inputStr.charAt(2))) {
                case SHOW:
                    System.out.println("== L. 查看数据（参数：id,name,sex,birthday,address,call）  ==");
                    break;
                case ADD:
                    System.out.println("== A. 添加数据（参数：name,sex,birthday,address,call）  =====");
                    break;
                case UPDATE:
                    System.out.println("== U. 修改数据（参数：id,name,sex,birthday,address,call）  ==");
                    break;
                case DELETE:
                    System.out.println("== D. 删除数据（参数：ID）                                 ==");
                    break;
                case ORDER:
                    System.out.println("== O. 对数据进行排序（参数：id/name）                       ==");
                    break;
                case HELP:
                    System.out.println("== H. 查看帮助                                            ==");
                    break;
                case EXIT:
                    System.out.println("== Q. 退出                                                ==");
                    break;
            }
        }else {
            System.out.println("== L. 查看数据（参数：id,name,sex,birthday,address,call）  ==");
            System.out.println("== A. 添加数据（参数：name,sex,birthday,address,call）  =====");
            System.out.println("== D. 删除数据（参数：ID）                                 ==");
            System.out.println("== U. 修改数据（参数：id,name,sex,birthday,address,call）  ==");
            System.out.println("== O. 对数据进行排序（参数：id/name）                       ==");
            System.out.println("== H. 查看帮助                                            ==");
            System.out.println("== Q. 退出                                                ==");
        }
        System.out.println("============================================================");
    }

    public void handleInput(String inputStr) {
        try {
            String type = fetchOperationType(inputStr);

            switch (type) {
                case SHOW:
                    dataUtil.showData();
                    break;
                case ADD:
                    dataUtil.addData();
                    break;
                case DELETE:
                    dataUtil.deleteData();
                    break;
                case UPDATE:
                    dataUtil.updateData();
                    break;
                case ORDER:
                    dataUtil.sortData();
                    break;
                case HELP:
                    showHelp(inputStr);
                    break;
                default:
                    System.out.println("usage H for Looking Help...");
            }
        } catch (Exception ex) {
            System.out.println("usage H for Looking Help...");
        }
    }

    private String fetchOperationType(String inputStr) {
        dataUtil.setInputParamsString(parseInputString(inputStr));
        return String.valueOf(inputStr.charAt(0));
    }

    private String parseInputString(String inputStr) {
        if (inputStr.length() > 2) {
            if (inputStr.charAt(1) == ' ') {
                return inputStr.substring(2, inputStr.length());
            } else {
                throw new FormatException();
            }
        } else if (inputStr.length() == 1 && inputStr.equals("L")) {
            return inputStr;
        } else {
            return null;
        }
    }
}
