package servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * Created by CHENCO7 on 7/25/2017.
 */
@WebServlet(urlPatterns = "/regist2")
public class Regist2Servlet extends HttpServlet {
    private UserService userService;

    public Regist2Servlet() {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        DiskFileItemFactory factory = new DiskFileItemFactory(200*1024,new File("D:/bin/temp"));
//        ServletFileUpload upload = new ServletFileUpload(factory);
//        upload.setHeaderEncoding("utf-8");
//        upload.setFileSizeMax(250*1024);
        String name = "";
        String salary = "";
        String birth = "";
        String sex = "";
        byte[] avatar = null;

        DiskFileItemFactory factory = new DiskFileItemFactory(100 * 1024, new File("D:\\bin\\temp"));
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setFileSizeMax(150 * 1024); // 50k 文件大小

        try {
            List<FileItem> itemList = upload.parseRequest(req);
            for (FileItem item : itemList){
                if(item.isFormField()){
                    System.out.println(item.getFieldName() + " ... " + item.getString());
                    if ("name".equals(item.getFieldName())) {
                        name = item.getString("utf-8");
                    }
                    if ("salary".equals(item.getFieldName())) {
                        salary = item.getString("utf-8");
                    }
                    if ("birth".equals(item.getFieldName())) {
                        birth = item.getString("utf-8");
                    }
                    if ("sex".equals(item.getFieldName())) {
                        sex = item.getString("utf-8");
                    }
                }else {
                    System.out.println(item.getName() + " ___ " + item.getSize());
                    byte[] buffer = new byte[512];
                    int len = 0;
                    InputStream in = item.getInputStream();
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    while ((len = in.read(buffer)) != -1) {
                        out.write(buffer, 0, len);
                    }
                    out.flush();
                    avatar = out.toByteArray();
                    in.close();
                    out.close();
                }
            }
        } catch (FileUploadException e) {
            // 当文件体积过大的时候, 会抛出异常..
            e.printStackTrace();
        }

        userService.addUser2(name, birth, salary, sex, avatar);

    }
}
