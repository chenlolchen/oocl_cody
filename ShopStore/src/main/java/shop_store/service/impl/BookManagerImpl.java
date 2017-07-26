package shop_store.service.impl;


import shop_store.dao.BookDao;
import shop_store.dao.impl.BookDaoImpl;
import shop_store.pojo.Book;
import shop_store.service.BookManager;

import java.util.List;

/**
 * Created by CHENCO7 on 7/25/2017.
 */
public class BookManagerImpl implements BookManager {
    private BookDao bookDao;

    public BookManagerImpl() {
        this.bookDao = new BookDaoImpl();
    }

    public List<Book> findAllBooks() {
        return bookDao.findAllBooks();
    }
}
