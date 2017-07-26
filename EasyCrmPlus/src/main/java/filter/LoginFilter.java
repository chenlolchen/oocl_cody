package filter;

import org.apache.log4j.Logger;
import pojo.Customer;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by CHENCO7 on 7/26/2017.
 */
@WebFilter("/sec/*")
public class LoginFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Customer c = (Customer) session.getAttribute("c");
        if (c != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            response.sendRedirect("../login.jsp");
        }
    }

    public void destroy() {

    }
}
