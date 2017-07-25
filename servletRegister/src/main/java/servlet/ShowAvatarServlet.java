package servlet;


import dao.UserDao;
import dao.impl.UserDaoImpl;
import pojo.User;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by CHENCO7 on 7/25/2017.
 */
@WebServlet("/showAva")
public class ShowAvatarServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDao;

    public ShowAvatarServlet() {
        userDao = new UserDaoImpl();
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("name");
        User user = userDao.loadUser2(username);
        if (user != null) {
            byte[] bytes = user.getAvatar();
            OutputStream out = response.getOutputStream();
            response.setContentType("image/jpeg;charset=utf-8");
            out.write(bytes);
            out.close();
        }
    }
}
