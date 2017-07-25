package listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by CHENCO7 on 7/25/2017.
 */
@WebListener
public class MySessionListener implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println(httpSessionEvent.getSession().getId() + " ... created");
        ServletContext context = httpSessionEvent.getSession().getServletContext();
        synchronized (context){
            int count = (Integer) context.getAttribute("count");
            context.setAttribute("count", ++count);
        }
    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println(httpSessionEvent.getSession().getId() + " ... destroy");
        ServletContext context = httpSessionEvent.getSession().getServletContext();
        synchronized (context){
            int count = (Integer) context.getAttribute("count");
            context.setAttribute("count", --count);
        }
    }
}
