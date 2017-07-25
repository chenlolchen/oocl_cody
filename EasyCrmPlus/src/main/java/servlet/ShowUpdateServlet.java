package servlet;

import pojo.Customer;
import service.CustomerManager;
import service.impl.CustomerManagerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by CHENCO7 on 7/25/2017.
 */
@WebServlet(urlPatterns = "/update")
public class ShowUpdateServlet extends HttpServlet {
    private CustomerManager manager;

    public ShowUpdateServlet() {
        manager = CustomerManagerFactory.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Customer customer = manager.loadCustomer(id);
        req.setAttribute("customer", customer);
        req.getRequestDispatcher("edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
