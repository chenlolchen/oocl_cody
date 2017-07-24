package servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by CHENCO7 on 7/24/2017.
 */
@WebServlet(urlPatterns = "/upload")
public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DiskFileItemFactory factory = new DiskFileItemFactory(20 * 1024, new File("D:\\bin\\temp"));
        String path = getServletContext().getRealPath("/ff.png");
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setFileSizeMax(100 * 1024); // 50k 文件大小
        try {
            List<FileItem> itemList = upload.parseRequest(req);
            for (FileItem item : itemList){
                if(item.isFormField()){
                    System.out.println(item.getFieldName() + " ... " + item.getString());
                }else {
                    System.out.println(item.getName() + " ___ " + item.getSize());
                    InputStream in = item.getInputStream();
                    byte[] buf = new byte[50];
                    FileOutputStream out = new FileOutputStream(path);
                    int len = 0;
                    while ((len = in.read(buf)) != -1){
                        out.write(buf, 0 , len);
                    }
                    in.close();
                    out.close();
                }
            }
        } catch (FileUploadException e) {
            // 当文件体积过大的时候, 会抛出异常..
            e.printStackTrace();
        }

    }
}
