package servlet;

import service.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by CHENCO7 on 7/26/2017.
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private CustomerServiceImpl service;

    public LoginServlet(){
        service = new CustomerServiceImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("uname");
        String psd = request.getParameter("psd");
//        "john".equals(uname) && "123".equals(psd)
        if(service.loadCustomer(uname, psd) != null){
            request.getRequestDispatcher("suc.jsp").forward(request, response);
        }else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
