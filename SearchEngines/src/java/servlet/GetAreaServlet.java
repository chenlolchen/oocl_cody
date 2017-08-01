package servlet;

import pojo.Area;
import service.AreaManager;
import service.AreaManagerFactory;
import util.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by CHENCO7 on 8/1/2017.
 */
public class GetAreaServlet extends HttpServlet{
    private AreaManager areaManager;

    public GetAreaServlet(){
        this.areaManager = AreaManagerFactory.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        System.out.println("阿什顿");
        String areaName = req.getParameter("areaName");
        List<Area> areaList = areaManager.searchAreaByName(areaName);
        PrintWriter writer = resp.getWriter();
        writer.write(JsonUtil.toJsonString(areaList));
    }
}
