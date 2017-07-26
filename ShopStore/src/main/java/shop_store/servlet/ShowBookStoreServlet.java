package shop_store.servlet;

import shop_store.pojo.Book;
import shop_store.service.BookManager;
import shop_store.service.impl.BookManagerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by CHENCO7 on 7/26/2017.
 */
@WebServlet(urlPatterns = "/sec/showBookStore")
public class ShowBookStoreServlet extends HttpServlet {
    private BookManager manager;

    public ShowBookStoreServlet() {
        manager = BookManagerFactory.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = manager.findAllBooks();
        req.setAttribute("books", books);
        req.getRequestDispatcher("/shop.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
