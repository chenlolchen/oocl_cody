package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by CHENCO7 on 7/25/2017.
 */
@WebListener()
public class MyServletContextListener implements ServletContextListener {
    public MyServletContextListener() {
        System.out.println("servlet content construct");
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("listen context start ...");
        int count = 0;
        servletContextEvent.getServletContext().setAttribute("count", count);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("listen context destroy ...");
    }
}
