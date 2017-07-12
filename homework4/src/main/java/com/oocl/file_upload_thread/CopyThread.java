package com.oocl.file_upload_thread;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;

/**
 * Created by chen on 2017/7/12.
 */
public class CopyThread implements Runnable {
    private String sourceFileName;
    private String targetFileName;
    private int blockCount;
    private int blockNumber;
    private final int MAX_SIZE = 1024 * 1024;

    public CopyThread(String sourceFileName, String targetFileName, int blockCount, int blockNumber) {
        this.sourceFileName = sourceFileName;
        this.targetFileName = targetFileName;
        this.blockCount = blockCount;
        this.blockNumber = blockNumber;
    }

    public void run() {
        File file = new File(sourceFileName);
        long fileTotalSize = file.length();
        long blockLength = fileTotalSize / blockCount;
        long startPosition = blockLength * blockNumber;

        byte[] buff = new byte[MAX_SIZE];

        try {
            InputStream in = new FileInputStream(sourceFileName);
            in.skip(startPosition);
            RandomAccessFile out = new RandomAccessFile(targetFileName, "rw");
            out.seek(startPosition);

            int len;
            int readLength = 0;
            while ((len = in.read(buff)) > 0 && readLength < blockLength) {
                out.write(buff, 0, len);
                readLength += len;
            }
            out.close();
            in.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}