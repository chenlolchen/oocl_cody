//package servlet;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.concurrent.BlockingQueue;
//
///**
// * Created by CHENCO7 on 7/24/2017.
// */
//public class TestServlet extends HttpServlet{
//    private int m; // 不要轻易使用成员变量， 要么可以用 常量, 或者 BlockingQueue
//
//    @Override
//    public void init() throws ServletException {
//        System.out.println("init");
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        m++;
//        System.out.println("test  ..." + m);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("post ...");
//    }
//
//    @Override
//    public void destroy() {
//        System.out.println("destroy ... ");
//    }
//}
