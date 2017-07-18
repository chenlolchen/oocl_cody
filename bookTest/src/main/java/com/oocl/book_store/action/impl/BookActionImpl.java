package com.oocl.book_store.action.impl;

import com.oocl.book_store.action.BookAction;
import com.oocl.book_store.dao.BookDao;
import com.oocl.book_store.dao.impl.BookDaoImpl;
import com.oocl.book_store.pojo.Book;
import com.oocl.book_store.thread.DBWriteThread;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by CHENCO7 on 7/18/2017.
 */
public class BookActionImpl implements BookAction {
    public List<Book> initData(int dataNumber){
        List<Book> bookList = new ArrayList<Book>();
        for(int m = 1; m <= dataNumber; m++){
            bookList.add(new Book(m, "php", new Date(), "sky", 55.75, false, "cody"));
        }
        return bookList;
    }

    public void saveDataToFile(List<Book> bookList) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("test.data")));
            out.writeObject(bookList);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Book> readData(){
        List<Book> list = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("test.data")));
            list = (ArrayList<Book>) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void saveDataToDB(List<Book> bookList, int dataNumber, int threadNumber){
        int start = 0;
        int blockSize = dataNumber / threadNumber;
        int end = blockSize;
        DBWriteThread dbThread;
        for(int i = 0; i < threadNumber - 1; i++){
            dbThread = new DBWriteThread(start, end, bookList);
            new Thread(dbThread).start();
            start += blockSize;
            end += blockSize;
        }

        //处理最后一个模块
        dbThread = new DBWriteThread(start, dataNumber, bookList);
        new Thread(dbThread).start();
    }
}
