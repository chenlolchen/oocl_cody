package com.oocl.test;

import java.io.File;

public class TestMain {

    public static void main(String[] args) {
        String srcPath = "e:\\maven.zip";
        String destPath = "e:\\maven2.zip";
        File f = new File(srcPath);
        long len = f.length();
        int count = 3;
        int oneNum = (int) (len / count);

        for (int i = 0; i < count - 1; i++) {
            CopyThread ct = new CopyThread(srcPath, destPath, oneNum * i, oneNum * (i + 1));
            ct.start();
        }

        CopyThread ct = new CopyThread(srcPath, destPath, oneNum * (count - 1), (int) len);
        ct.start();

    }

}
