package shop_store.servlet;

import shop_store.pojo.Customer;
import shop_store.pojo.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by CHENCO7 on 7/26/2017.
 */
@WebServlet(urlPatterns = "/sec/addToShopCar")
public class AddToShopCarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        HttpSession session = req.getSession();
        List<Order> orderList = (List<Order>) session.getAttribute("orderList");
        Order order = null;
        if(orderList == null){
            orderList = new ArrayList<Order>();
            order = new Order();
            order.setId(UUID.randomUUID().toString());
            order.setAmount(1);
            order.setBookId(id);
            Customer customer = (Customer) session.getAttribute("customer");
            order.setCustomerId(customer.getId());
            orderList.add(order);
        }else {
            boolean flag = true;
            for (Order o : orderList){
                if(o.getBookId().equals(id)){
                    int amount = o.getAmount();
                    o.setAmount(++amount);
                    flag = false;
                }
            }
            if(flag){
                order = new Order();
                order.setId(UUID.randomUUID().toString());
                order.setAmount(1);
                order.setBookId(id);
                Customer customer = (Customer) session.getAttribute("customer");
                order.setCustomerId(customer.getId());
                orderList.add(order);
            }
        }
        session.setAttribute("orderList", orderList);
        resp.sendRedirect("../showShopCar.jsp");
    }
}
