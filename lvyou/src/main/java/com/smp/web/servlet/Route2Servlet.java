package com.smp.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smp.domain.PageBean;
import com.smp.domain.ResponseInfo;
import com.smp.service.RouteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//category pageBean 后台
@WebServlet("/route2Servlet")
public class Route2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //接收请求，获取参数
        String cidStr = request.getParameter("cid");
        //字符串类型
        String currentPageStr = request.getParameter("currentPage");
        //设置多少页
        String pageSizeStr = request.getParameter("pageSize");

        int cid = 0;
        try {
            cid=Integer.parseInt(cidStr);
        }catch (NumberFormatException e){
            e.printStackTrace();
        }

        //当前页号第一页
        int currentPage=1;
        try {
            currentPage = Integer.parseInt(currentPageStr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //设置每页记录数为20
        int pageSize = 20;
        try {
            pageSize = Integer.parseInt(pageSizeStr);//11
        } catch (Exception e) {
            e.printStackTrace();
        }

        //处理参数
        RouteService routeService = new RouteService();
        //PageBean pb =  routeService.search("长沙",1,20);
        //分页数据对象
        PageBean pb =  routeService.findPageByCid(cid,currentPage,pageSize);

        //响应浏览器,生成json
        ResponseInfo responseInfo = new ResponseInfo();
        responseInfo.setCode(200);
        responseInfo.setData(pb);
        String json = new ObjectMapper().writeValueAsString(responseInfo);
        //响应浏览器
        response.getWriter().println(json);
    }
}