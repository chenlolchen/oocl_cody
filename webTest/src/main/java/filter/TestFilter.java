package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by CHENCO7 on 7/25/2017.
 */
@WebFilter(urlPatterns = "/login")
public class TestFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("TestFilter init ...");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("TestFilter before ...");
        servletRequest.setCharacterEncoding("utf-8");

        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("TestFilter after ...");
    }

    public void destroy() {
        System.out.println("TestFilter destroy ...");
    }
}
