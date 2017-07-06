package com.oocl.util;

/**
 * Created by CHENCO7 on 7/6/2017.
 */
public class HelpUtil {
    public static void showHelp(){

    }

    public static void handleInput(String inputStr){
        switch (inputStr.charAt(0)){
            case 'L':
                System.out.println('L');
                break;
            case 'A':
                break;
            case 'D':
                break;
            case 'U':
                break;
            case 'O':
                break;
            case 'H':
                break;
            default:
                System.out.println("usage H for Looking Help...");
        }
    }


}
