package servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENCO7 on 7/24/2017.
 */
@WebServlet(urlPatterns = {"/ts"}, initParams = {@WebInitParam(name = "encoding", value = "utf-8")})
public class Test2 extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        String encoding = config.getInitParameter("encoding");
        System.out.println("encoding == " + encoding);
//        String a = this.getServletContext()
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("test  ...");
//        Enumeration<String> e = req.getHeaderNames();
//        while (e.hasMoreElements()) {
//            String headerName = e.nextElement();//透明称
//            Enumeration<String> headerValues = req.getHeaders(headerName);
//            while (headerValues.hasMoreElements()) {
//                System.out.println(headerName + ":" + headerValues.nextElement());
//            }
//        }
//
//        String uname = req.getParameter("uname");
//        // 生命周期 : 一次请求
//        req.setAttribute("un", uname);
//        req.getAttribute("un");
//        req.getRequestDispatcher("/target").forward(req, resp);
////        resp.sendRedirect("/target");
//        resp.getWriter().write("Hello: " + uname);
//
////        Enumeration<String> e = req.getHeaders("Accept-Encoding");//得到的头值
////        while(e.hasMoreElements()){
////            String headerValue = e.nextElement();
////            System.out.println(headerValue);
////        }



////      这个东西就是令牌 : JSESSIONID=75EE8E3E8F3DB3745BF22CA3200EE032
//        HttpSession session = req.getSession();
//        session.setAttribute("uname", "chen");
//        PrintWriter printWriter = resp.getWriter();
//        printWriter.write("this is test");



        String item = req.getParameter("item");
        HttpSession session = req.getSession();
        List<String> list = (List<String>) session.getAttribute("cart");
        if (list == null){
            list = new ArrayList<String>();
            session.setAttribute("cart", list);
        }

        list.add(item);
        session.setAttribute("cart", list);
        resp.sendRedirect("/target");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post ...");
        doGet(req, resp);
    }
}
