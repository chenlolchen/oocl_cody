package com.oocl.test;

/**
 * Created by CHENCO7 on 7/10/2017.
 */
public class TestRandom {
    public static void range(int begin, int end){
        int result = (int) (Math.random() * (end - begin + 1) + begin);
        System.out.println(result);
    }

    public static int getRange(int begin, int end){
        int result = (int) (Math.random() * (end - begin + 1) + begin);
        return result;
    }

    public static int[] testProbability(){
        int[] count = new int[11];
        int temp = getRange(0,100);
        int result;
        if(temp < 30){
            result = 5;
        }else {
            while (true){
                int t = getRange(0,10);
                if(t != 5){
                    result = t;
                    count[t]++;
                    break;
                }
            }
        }
        System.out.println(result);
        return count;
    }

    public static void main(String[] args) {
//        for(int i = 0; i < 500; i++){
//            range(50,100);
//        }

        for(int i = 0; i < 10000; i++){
            testProbability();
        }


    }
}
