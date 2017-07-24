package servlet;

import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

/**
 * Created by CHENCO7 on 7/24/2017.
 */
@WebServlet(urlPatterns = "/success")
public class SuccessServlet extends HttpServlet {
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userService = new UserServiceImpl();
        String name = (String) req.getAttribute("name");
        User user = userService.loadUser(name);
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.write("<table>");
        writer.write("<tr>");
        writer.write("<td>");
        writer.write(user.getName());
        writer.write("</td>");
        writer.write("<td>");
        writer.write(String.valueOf(user.getSalary()));
        writer.write("</td>");
        writer.write("<td>");
        writer.write(String.valueOf(user.getSex()));
        writer.write("</td>");
        writer.write("<td>");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date = format.format(user.getBirth());
        writer.write(date);
        writer.write("</td>");
        writer.write("</tr>");
        writer.write("</table>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

