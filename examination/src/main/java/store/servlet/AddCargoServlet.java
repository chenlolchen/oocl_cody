package store.servlet;

import store.pojo.Cargo;
import store.service.CargoManager;
import store.service.impl.CargoManagerFactory;
import store.util.DateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * Created by CHENCO7 on 7/27/2017.
 */
@WebServlet("/sec/addCargo")
public class AddCargoServlet extends HttpServlet {
    private CargoManager manager;

    public AddCargoServlet() {
        manager = CargoManagerFactory.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String storeId = req.getParameter("storeId");
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        String amount = req.getParameter("amount");
        String createdDate = req.getParameter("created_at");

        //校验

        Date date = DateUtil.formatDate(createdDate);
        Double cargoPrice = Double.valueOf(price);
        Integer cargoAmount = Integer.valueOf(amount);

        Cargo cargo = new Cargo(UUID.randomUUID().toString(), name, cargoPrice, cargoAmount, date, storeId);
        if(manager.addCargo(cargo) > 0){
            resp.sendRedirect("../sec/showCargoList?storeId=" + storeId);
        }else {
            req.getRequestDispatcher("addForm.jsp").forward(req, resp);
        }

    }
}
