package com.oocl.test;

import java.io.*;
import java.nio.channels.FileChannel;

public class CopyThread extends Thread {

    private String srcPath;
    private String destPath;
    private int start;
    private int end;

    public CopyThread(String srcPath, String destPath, int start, int end) {
        this.srcPath = srcPath;
        this.destPath = destPath;
        this.start = start;
        this.end = end;
    }

    public void run() {
        try {
            RandomAccessFile in = new RandomAccessFile(srcPath, "r");
            RandomAccessFile out = new RandomAccessFile(destPath, "rw");
            in.seek(start);
            out.seek(start);
//            FileOutputStream o = new FileOutputStream("c://project2.rar");
//            InputStream i = new FileInputStream("aa");
//            i.skip()
//            int len = 0;
//            byte[] buf = new byte[1024];
//            while ((len = in.read(buf, start, 1024)) != -1){
//                out.write(buf,start,len);
//            }

            FileChannel inChannel = in.getChannel();
            FileChannel outChannel = out.getChannel();
////            FileLock lock = outChannel.lock(start, (end - start), false);
            inChannel.transferTo(start, (end - start), outChannel);
//            lock.release();
            out.close();
            in.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
