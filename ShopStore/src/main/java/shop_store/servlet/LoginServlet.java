package shop_store.servlet;

import org.apache.log4j.Logger;
import shop_store.pojo.Customer;
import shop_store.service.CustomerManager;
import shop_store.service.impl.CustomerManagerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by CHENCO7 on 7/26/2017.
 */
@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet{
    private CustomerManager manager;
    private static Logger logger = Logger.getLogger(LoginServlet.class);

    public LoginServlet() {
        manager = CustomerManagerFactory.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        Customer customer = manager.loadCustomer(name, password);
        System.out.println(customer);
        if(customer != null){
            logger.debug("user " + name + "is login");
            HttpSession session = req.getSession();
            session.setAttribute("customer", customer);
            req.getRequestDispatcher("sec/showBookStore").forward(req, resp);
        }else {
            resp.sendRedirect("login.jsp");
        }
    }
}
