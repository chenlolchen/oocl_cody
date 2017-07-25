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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by CHENCO7 on 7/25/2017.
 */
@WebServlet(urlPatterns = "/add")
public class AddCustomerServlet extends HttpServlet{
    private CustomerManager manager;

    public AddCustomerServlet() {
        manager = CustomerManagerFactory.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接参
        String cname = req.getParameter("name");
        String csex = req.getParameter("sex");
        String csal = req.getParameter("sal");
        String cbirth = req.getParameter("birth");
        String[] cfavs = req.getParameterValues("favs");
        // 校验
        // regular

        // 类型转换
        boolean sex = Boolean.parseBoolean(csex);
        double sal = Double.parseDouble(csal);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date birth = null;
        try {
            birth = format.parse(cbirth);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // 封装
        Customer customer = new Customer(null, cname, sal, sex, birth, cfavs);

        // 调用业务
        int m = manager.addCustomer(customer);
        if (m > 0){
            resp.sendRedirect("list");
        }else {
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }
}
