package servlet;

import org.easymock.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import pojo.Customer;
import service.CustomerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.easymock.EasyMock.*;

/**
 * Created by CHENCO7 on 7/26/2017.
 */
public class LoginServletTest extends EasyMockSupport {
    @Rule
    public EasyMockRule rule = new EasyMockRule(this);

    @TestSubject
    private LoginServlet servlet = new LoginServlet();
    // @Mock 依赖 EasyMockRule
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private RequestDispatcher requestDispatcher;
    @Mock
    private CustomerServiceImpl service;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testDoGet(){
        expect(request.getParameter("uname")).andReturn("john");
        expect(request.getParameter("psd")).andReturn("123");
        expect(service.loadCustomer("john","123")).andReturn(new Customer("john","123"));
        expect(request.getRequestDispatcher("suc.jsp")).andReturn(requestDispatcher);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        replay(request);
//        replay(response);
//        replay(requestDispatcher);
        replayAll();

        // 用户名密码验证
//        service.loadCustomer(request.getParameter("uname"), request.getParameter("psd"));

        try {
            servlet.doGet(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        verify(request);
//        verify(response);
//        verify(requestDispatcher);
        verifyAll();

//        reset(request);
//        reset(response);
//        reset(requestDispatcher);
        resetAll();

        expect(request.getParameter("uname")).andReturn("john");
        expect(request.getParameter("psd")).andReturn("1234");
        expect(service.loadCustomer("john","1234")).andReturn(null);
        expect(request.getRequestDispatcher("login.jsp")).andReturn(requestDispatcher);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        replayAll();

        try {
            servlet.doGet(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        verifyAll();

    }

}