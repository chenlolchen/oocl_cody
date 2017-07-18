package com.oocl.book_store.action;

import com.oocl.book_store.pojo.Book;

import java.util.List;

/**
 * Created by CHENCO7 on 7/18/2017.
 */
public interface BookAction {
    List<Book> initData(int dataNumber);

    void saveDataToFile(List<Book> bookList);

    List<Book> readData();

    void saveDataToDB(List<Book> bookList, int dataNumber, int threadNumber);
}
