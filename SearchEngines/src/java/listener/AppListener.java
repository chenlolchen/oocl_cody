package listener;



import util.DBUtil;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

/**
 * Created by CHENCO7 on 7/26/2017.
 */
@WebListener
public class AppListener implements ServletContextListener {
    public AppListener() {

    }

    public void contextInitialized(ServletContextEvent sce) {

        InitialContext cxt = null;
        try {
            cxt = new InitialContext();
            DataSource ds = (DataSource) cxt.lookup("java:/comp/env/jdbc/myoracle");
            DBUtil.setDataSource(ds);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public void contextDestroyed(ServletContextEvent sce) {
    }

}
