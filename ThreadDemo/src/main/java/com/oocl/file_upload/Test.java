package com.oocl.file_upload;

/**
 * Created by chen on 2017/7/12.
 */
public class Test {

    /**
     * @param args
     */
    //来源文件
    private static String sourceFile;
    //目标文件
    private static String targetFile;
    //分块数
    private static int blockCount;

    public static void main(String[] args) {
        sourceFile="e://test.jpg";
        targetFile="e://test2.jpg";
        blockCount=Integer.parseInt("3");
        //记录开始时间
        long beginTime=System.currentTimeMillis();
        //依次分块进行文件COPY
        for(int i=0;i<blockCount;i++)
        {
            //实例化文件复制对象
            CopyFile copyFile=new CopyFile(sourceFile,targetFile,blockCount,i);
            //实例化线程
            Thread thread=new Thread(copyFile);
            //开始线程
            thread.start();
        }
        //计算耗时
        long endTime=System.currentTimeMillis();
        //输出耗时
        System.out.println("共用时:"+(endTime-beginTime)+"ms");

    }

}
