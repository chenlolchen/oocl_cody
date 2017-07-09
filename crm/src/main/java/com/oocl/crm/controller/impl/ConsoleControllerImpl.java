package com.oocl.crm.controller.impl;

import com.oocl.crm.controller.ConsoleController;
import com.oocl.crm.exception.FormatException;
import com.oocl.crm.parser.CmdParser;
import com.oocl.crm.parser.impl.CmdParserImpl;
import com.oocl.crm.util.FormatPrinter;

import java.util.Scanner;

/**
 * Created by chen on 2017/7/9.
 */
public class ConsoleControllerImpl implements ConsoleController {
    private static final String ADD = "A";
    private static final String UPDATE = "U";
    private static final String DELETE = "D";
    private static final String ORDER = "O";
    private static final String SHOW = "L";
    private static final String HELP = "H";
    private static final String EXIT = "Q";
    private CmdParser cmdParser;

    public ConsoleControllerImpl(){
        cmdParser = new CmdParserImpl();
        showHelp("H");
    }

    @Override
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

    @Override
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

    @Override
    public void handleInput(String inputStr) {
        try {
            String type = FormatPrinter.fetchOperationType(inputStr);
            String paramsString = FormatPrinter.parseInputString(inputStr);

            switch (type) {
                case SHOW:
                    cmdParser.showData(paramsString);
                    break;
                case ADD:
                    cmdParser.addData(paramsString);
                    break;
                case DELETE:
                    cmdParser.deleteData(paramsString);
                    break;
                case UPDATE:
                    cmdParser.updateData(paramsString);
                    break;
                case ORDER:
                    cmdParser.sortData(paramsString);
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
}
