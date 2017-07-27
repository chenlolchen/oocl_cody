package store.servlet;

import store.service.CargoManager;
import store.service.impl.CargoManagerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by CHENCO7 on 7/27/2017.
 */
@WebServlet(urlPatterns = "/sec/deleteCargo")
public class DeleteCargoServlet extends HttpServlet{
    private CargoManager manager;

    public DeleteCargoServlet() {
        manager = CargoManagerFactory.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deleteId = req.getParameter("id");
        String storeId = req.getParameter("storeId");
        if(manager.deleteCargoById(deleteId) > 0){
            resp.sendRedirect("../sec/showCargoList?storeId=" + storeId);
        }else {
            resp.sendRedirect("../sec/error.jsp");
        }
    }
}
