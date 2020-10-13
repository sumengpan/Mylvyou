package com.smp.web.servlet;

import com.smp.domain.Route;
import com.smp.service.RouteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//
//成员变量的select属性配置 与 延迟加载
@WebServlet("/routedetail/*")
public class RouteDetailServlet extends BaseServlet {

    public void find(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        //1 接收请求，获取参数
        //业务，根据 路线的rid查找 路线的数据，商家的数据，分类的数据，图片的数据
        String ridStr = request.getParameter("rid");
        int rid = 1; //"1"
        try {
            rid = Integer.parseInt(ridStr);
        } catch (NumberFormatException e) { //Ctrl+Alt+T格式化
            e.printStackTrace();
        }
        //2 处理参数
        RouteService routeService = new RouteService();

        Route route = routeService.findRouteById2(rid);

        //3 响应浏览器
        String json = toJson(200,route);
        response.getWriter().println(json);
    }
}