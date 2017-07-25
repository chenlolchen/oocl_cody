package servlet;

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
@WebServlet(urlPatterns = "/del")
public class DeleteCustomerServlet extends HttpServlet {
    private CustomerManager manager;

    public DeleteCustomerServlet() {
        manager = CustomerManagerFactory.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int result = manager.delCustomerById(id);
    }
}
