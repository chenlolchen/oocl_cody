package servlet;

import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;
import util.RegularUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;

/**
 * Created by CHENCO7 on 7/24/2017.
 */
@WebServlet(urlPatterns = "/regist")
public class RegistServlet extends HttpServlet {
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
//        resp.setContentType("text/html; charset=utf-8");
//        System.out.println(System.getProperty("file.encoding"));
//        System.out.println(Charset.defaultCharset().name());

        String name = req.getParameter("name");
        String salary = req.getParameter("salary");
        String birth = req.getParameter("birth");
        String sex = req.getParameter("sex");

        if(!RegularUtil.regularCheck(salary, RegularUtil.SALARY)){
            resp.sendRedirect("/regist.html");
            return;
        }

        if(!RegularUtil.regularCheck(birth, RegularUtil.DATE)){
            resp.sendRedirect("/regist.html");
            return;
        }

        if(!RegularUtil.regularCheck(sex, RegularUtil.SEX)){
            resp.sendRedirect("/regist.html");
            return;
        }

        userService = new UserServiceImpl();
        if(userService.addUser(name, birth, salary, sex) > 0){
            req.setAttribute("name", name);
            req.getRequestDispatcher("/success").forward(req, resp);
        }else {
            resp.sendRedirect("/error");
        }
    }
}
