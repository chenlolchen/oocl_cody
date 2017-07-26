package shop_store.service.impl;

import shop_store.service.BookManager;

/**
 * Created by CHENCO7 on 7/26/2017.
 */
public class BookManagerFactory {
    private static BookManager manager;

    public static BookManager getInstance(){
        if (manager == null){
            manager = new BookManagerImpl();
        }
        return manager;
    }
}
