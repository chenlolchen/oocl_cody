package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by CHENCO7 on 7/24/2017.
 */
@WebServlet(urlPatterns = {"/ts"})
public class Test2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("test  ...");
        Enumeration<String> e = req.getHeaderNames();
        while (e.hasMoreElements()) {
            String headerName = e.nextElement();//透明称
            Enumeration<String> headerValues = req.getHeaders(headerName);
            while (headerValues.hasMoreElements()) {
                System.out.println(headerName + ":" + headerValues.nextElement());
            }
        }

        String uname = req.getParameter("uname");
        // 生命周期 : 一次请求
        req.setAttribute("un", uname);
        req.getAttribute("un");
        req.getRequestDispatcher("/target").forward(req, resp);
//        resp.sendRedirect("/target");
        resp.getWriter().write("Hello: " + uname);

//        Enumeration<String> e = req.getHeaders("Accept-Encoding");//得到的头值
//        while(e.hasMoreElements()){
//            String headerValue = e.nextElement();
//            System.out.println(headerValue);
//        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post ...");
        doGet(req, resp);
    }
}
