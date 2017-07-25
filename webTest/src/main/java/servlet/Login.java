package servlet;

import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by CHENCO7 on 7/24/2017.
 */
@WebServlet(urlPatterns = {"/lll"})
public class Login extends HttpServlet {

    @Override
    public void init() throws ServletException {
        User user = new User("chen", "123");
        this.getServletContext().setAttribute("user", user);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String info = "登录错误";
        String uname = req.getParameter("uname");
        String password = req.getParameter("password");
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter printWriter = resp.getWriter();

        User user = (User) this.getServletContext().getAttribute("user");
        if(user.getUname().equals(uname) && user.getPassword().equals(password)){
            User u = new User(uname, password);
            req.getSession().setAttribute("u", u);
            info = "登录成功";
//            printWriter.write("<h1>登录成功！</h1>");
        }else {
//            printWriter.write("<h1>登录失败！</h1>");
        }

        printWriter.write(info);
        printWriter.close();
//        System.out.println(uname + password);
    }
}
