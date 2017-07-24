package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by CHENCO7 on 7/24/2017.
 */
@WebServlet(urlPatterns = {"/target"})
public class TargetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String un = (String) req.getAttribute("un");
        System.out.println("un == " + un);
        resp.setCharacterEncoding("UTF-8"); // 服务器发送的编码
//        resp.sendRedirect("http://www.baidu.com");
        resp.setContentType("text/html; charset=UTF-8"); //告诉浏览器
        resp.addHeader("Accept-Type", "text/html123");
        String s = "中国";
        resp.getWriter().write(s); // 字符
//        resp.getOutputStream().write(s.getBytes("utf-8")); // 字节
    }
}
