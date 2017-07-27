package store.servlet;

import store.pojo.Cargo;
import store.pojo.Store;
import store.service.CargoManager;
import store.service.StoreManager;
import store.service.impl.CargoManagerFactory;
import store.service.impl.StoreManagerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by CHENCO7 on 7/27/2017.
 */
@WebServlet(urlPatterns = "/sec/showCargoList")
public class ShowCargoListServlet extends HttpServlet {
    private CargoManager manager;
    private StoreManager storeManager;

    public ShowCargoListServlet() {
        manager = CargoManagerFactory.getInstance();
        storeManager = StoreManagerFactory.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String storeId = req.getParameter("storeId");
        List<Cargo> cargoList = manager.getCargoListByStoreId(storeId);
        List<Store> storeList = storeManager.findAllStores();
        req.setAttribute("cargoList", cargoList);
        req.setAttribute("storeList", storeList);
        req.getRequestDispatcher("../sec/showCargo.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
