package servlet;

import util.DBUtil;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by CHENCO7 on 7/25/2017.
 */
@WebServlet(urlPatterns = "/", loadOnStartup = 1)
public class DataSourceInitialServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("load jndi ..");
        InitialContext cxt;
        try {
            cxt = new InitialContext();
            DataSource ds = (DataSource) cxt.lookup( "java:/comp/env/jdbc/myoracle" );
            DBUtil.setDataSource(ds);
        } catch (NamingException e) {
            e.printStackTrace();
        }

    }
}
