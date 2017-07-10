package com.oocl.random;

/**
 * Created by CHENCO7 on 7/10/2017.
 */
public class RandomTest {

    public static void main(String[] args) {
        int min = 0;
        int max = 10;
        int[] aims = {5,7};
        int[] probability = {30,30};
        generateRandomNumbers(min, max, aims, probability);
    }

    public static double countProbabilityNumber(int min, int max, int probability) {
        double denominator = (double) (max - min);
        double per = 1.0;
        double other = denominator - per;
        double pro = (double) probability / (double) 100;
        double result = (pro - (per / denominator)) / (other / denominator);
        return result;
    }

    private static void generateRandomNumbers(int min, int max, int[] aims, int[] probability) {
        int m = 100000;
        int[] as = new int[11];
        for (int i = 0; i < m; i++) {
            int rs = (int) (Math.random() * (max - min + 1)) + min;
            int sec = (int) (Math.random() * 100 * max - min) + 1;
            int temp[] = new int[11];
            int sum = 0;
            for(int j = 0; j < aims.length; j++){
                temp[j] = (int) (countProbabilityNumber(min, max, probability[0]) * m) / 100;
                if(j == 0){
                    if (sec <= temp[j]){
                        rs = aims[j];
                    }
                }else {
                    for(int k = j; k >= 0; k--){
                        sum += temp[k];
                    }
                    if (sum - temp[j] <= sec && sec <= sum){
                        rs = aims[j];
                    }
                }

            }
            as[rs]++;
        }

        for (int i = 1; i < as.length; i++) {
            System.out.println(i + "\t" + as[i]);
        }
    }
}
