package com.oocl.test;

/**
 * Created by CHENCO7 on 7/10/2017.
 */
enum Color{
    BLUE, RED
}



public class Test5 {
    public static void main(String[] args) {
        Color c = Color.RED;
        switch (c){
            case BLUE:
                break;
            case RED:
                break;
            default:

        }
    }
}

interface Color1{
    public static int BLUE = 1;
    public static int RED = 2;
}
