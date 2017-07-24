package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by CHENCO7 on 7/24/2017.
 */
@WebServlet(urlPatterns = "/images")
public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = this.getServletContext().getRealPath("/WEB-INF/images/Capture2.PNG");
        System.out.println(path);
        byte[] buf = new byte[512];
        InputStream in = new FileInputStream(path);
        OutputStream out = resp.getOutputStream();
//        resp.setHeader("Content-Type", "image/jpeg");

        // attachment　浏览器会认为它是一个附件
        resp.setHeader("Content-Disposition", "attachment; filename=aa.png");

        int len;
        while ((len = in.read(buf)) != -1){
            out.write(buf, 0 , len);
        }
        out.close();
        in.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
