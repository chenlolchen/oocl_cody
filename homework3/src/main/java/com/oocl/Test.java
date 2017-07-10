package com.oocl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by CHENCO7 on 7/10/2017.
 */
public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("abc.txt");
        Scanner scanner = new Scanner(fileInputStream);
        while (scanner.hasNext()){
            System.out.println(scanner.next());
        }
    }
}
