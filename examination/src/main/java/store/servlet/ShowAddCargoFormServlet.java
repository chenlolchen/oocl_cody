package store.servlet;


import store.pojo.Store;
import store.service.StoreManager;
import store.service.impl.StoreManagerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by CHENCO7 on 7/27/2017.
 */
@WebServlet(urlPatterns = "/sec/showAddCargoForm")
public class ShowAddCargoFormServlet extends HttpServlet {
    private StoreManager manager;

    public ShowAddCargoFormServlet() {
        manager = StoreManagerFactory.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Store> storeList = manager.findAllStores();
        req.setAttribute("storeList", storeList);
        req.getRequestDispatcher("addForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
