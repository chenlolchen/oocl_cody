package servlet;

import pojo.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //data from service
        User u=new User("ccc", "111");
        User u1=new User("eee", "888");
        request.getSession().setAttribute("u", u1);
        request.setAttribute("u", u);
        List<User> us=new ArrayList<User>();
        for(int i=0;i<10;i++){
            User uu=new User("John"+i, i + "PP");
            uu.setSal(11254765.84);
            uu.setBirth(new Date());
            uu.setSex(true);
            us.add(uu);
        }
        us.get(4).setSex(false);

        request.setAttribute("us", us);

        request.getRequestDispatcher("show.jsp").forward(request, response);
    }

}