package shop_store.dao;

import shop_store.pojo.Book;

import java.util.List;

/**
 * Created by CHENCO7 on 7/26/2017.
 */
public interface BookDao {
    List<Book> findAllBooks();
}
