package shop_store.servlet;

import shop_store.pojo.Order;
import shop_store.service.OrderManager;
import shop_store.service.impl.OrderManagerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by CHENCO7 on 7/26/2017.
 */
@WebServlet(urlPatterns = "/sec/buyBook")
public class BuyBookServlet extends HttpServlet{
    private OrderManager manager;

    public BuyBookServlet() {
        manager = OrderManagerFactory.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<Order> orderList = (List<Order>) session.getAttribute("orderList");
        for(Order order : orderList){
            manager.addOrder(order);
        }
        orderList.clear();
        resp.sendRedirect("../sec/showBookStore");
    }
}
