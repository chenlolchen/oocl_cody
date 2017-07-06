package com.oocl.util;

public class ConsoleUtil {
    private static final String ADD = "A";
    private static final String UPDATE = "U";
    private static final String DELETE = "D";
    private static final String ORDER = "O";
    private static final String SHOW = "L";
    private static final String HELP = "H";

    private DataUtil dataUtil;

    public ConsoleUtil(DataUtil dataUtil) {
        this.dataUtil = dataUtil;
    }

    public static void showHelp() {
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

    public void handleInput(String inputStr) {
        try {
            String type = dataUtil.fetchOperationType(inputStr);

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
                    showHelp();
                    break;
                default:
                    System.out.println("usage H for Looking Help...");
            }
        } catch (Exception ex) {
            System.out.println("usage H for Looking Help...");
        }
    }
}
