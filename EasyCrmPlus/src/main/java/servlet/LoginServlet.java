package servlet;

import org.apache.log4j.Logger;
import pojo.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by CHENCO7 on 7/26/2017.
 */
@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        System.out.println("login servlet ..");
        if(name.equals("chen") && password.equals("123")){
            Customer c = new Customer();
            c.setName(name);
            c.setPassword(password);
            req.getSession().setAttribute("c", c);
            resp.sendRedirect("sec/list");
        }else {
            req.getRequestDispatcher("../login.jsp").forward(req, resp);
        }
    }
}
