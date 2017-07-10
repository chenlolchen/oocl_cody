package com.oocl.regular;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by CHENCO7 on 7/10/2017.
 */
public class RegularTest {

    public static int countByRegular(String scannerText, String regx){
        int counter = 0;
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(scannerText);
        while (matcher.find()){
            counter++;
        }
        return counter;
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("abc.txt");
        int numberCounter = 0;
        int charaterCounter = 0;
        int pointCounter = 0;
        int chineseCharacterCounter = 0;

        Scanner scanner = new Scanner(fileInputStream);
        while (scanner.hasNext()){
            String scannerText = scanner.next();
            numberCounter += countByRegular(scannerText,"[0-9]");
            charaterCounter += countByRegular(scannerText,"[a-zA-Z]");
            pointCounter += countByRegular(scannerText,"\\p{P}");
            chineseCharacterCounter += countByRegular(scannerText, "[\\u4e00-\\u9fa5]");
        }

        System.out.println(numberCounter);
        System.out.println(charaterCounter);
        System.out.println(pointCounter);
        System.out.println(chineseCharacterCounter);
    }
}
