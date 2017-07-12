package com.oocl.file_upload_thread;

/**
 * Created by chen on 2017/7/12.
 */
public class TestCopyThread {
    public static void main(String[] args) {
        String sourceFile = "e://test.jpg";
        String targetFile = "e://test2.jpg";
        //线程数
        int blockCount = 3;
        for (int i = 0; i < blockCount; i++) {
            CopyThread copyThread = new CopyThread(sourceFile, targetFile, blockCount, i);
            new Thread(copyThread).start();
        }
    }

}
