package servlet;

import pojo.Customer;
import service.CustomerManager;
import service.impl.CustomerManagerFactory;
import util.RegularUtil;

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
@WebServlet(urlPatterns = "/sec/add")
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
        boolean isError = false;
        // 接参
        String cname = req.getParameter("name");
        String csex = req.getParameter("sex");
        String csal = req.getParameter("sal");
        String cbirth = req.getParameter("birth");
        String[] cfavs = req.getParameterValues("favs");
        // 校验
        if(cname.trim().length() < 3){
            req.setAttribute("ename", "名字错误");
            isError = true;
        }
        if(!RegularUtil.regularCheck(csex, RegularUtil.SEX)){
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
        if(!RegularUtil.regularCheck(cbirth, RegularUtil.DATE)){
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
        if(!RegularUtil.regularCheck(csal, RegularUtil.SALARY)){
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
        if (isError){
            req.setAttribute("name", cname);
            req.setAttribute("sal", csal);
            req.setAttribute("birth", cbirth);
            req.getRequestDispatcher("regist.jsp").forward(req, resp);
            return;
        }

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
            System.out.println("111111");
            resp.sendRedirect("sec/list");
        }else {
            System.out.println("22222222");
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }
}
