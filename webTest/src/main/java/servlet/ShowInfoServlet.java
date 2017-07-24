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
@WebServlet(urlPatterns = {"/show"})
public class ShowInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String info = "敏感信息！";
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        User u = (User) req.getSession().getAttribute("u");
        if (u == null){
            writer.write("你还没登录呢");
        }else {
            writer.write(info);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
