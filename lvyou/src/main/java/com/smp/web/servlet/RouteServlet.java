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



@WebServlet("/routeServlet")
public class RouteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //接收请求，获取参数
        String keyword = request.getParameter("keyword");
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        int currentPage = 1;
        if (currentPageStr != null && currentPageStr.length() > 0) {
            //"11"  "你好"
            try {
                currentPage = Integer.parseInt(currentPageStr);//11
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        int pageSize = 20;
        if (pageSizeStr != null && pageSizeStr.length() > 0) {
            //"30"  "你好"
            try {
                pageSize = Integer.parseInt(pageSizeStr);//11
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //处理参数
        RouteService routeService = new RouteService();
        //PageBean pb =  routeService.search("长沙",1,20);
        PageBean pb =  routeService.search(keyword,currentPage,pageSize);

        //响应浏览器
        ResponseInfo info = new ResponseInfo();
        info.setCode(200);
        info.setData(pb);
        String json = new ObjectMapper().writeValueAsString(info);
        response.getWriter().println(json);
    }
}











//@WebServlet("/routeServlet")
//public class RouteServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request, response);
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //接收请求，获取参数
//        String keyword = request.getParameter("keyword");
//        //字符串类型
//        String currentPageStr = request.getParameter("currentPage");
//        //设置多少页
//        String pageSizeStr = request.getParameter("pageSize");
//        //当前页号第一页
//        int currentPage = 1;
//
//        if (currentPageStr != null && currentPageStr.length() > 0) {
//            //如果当前页存在
//            try {
//                currentPage = Integer.parseInt(currentPageStr);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        //设置每页记录数为20
//        int pageSize = 20;
//        if (pageSizeStr != null && pageSizeStr.length() > 0) {
//            //如果大于20
//            try {
//                pageSize = Integer.parseInt(pageSizeStr);//11
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        //处理参数
//        RouteService routeService = new RouteService();
//        //PageBean pb =  routeService.search("长沙",1,20);
//        //分页数据对象
//        PageBean pb = routeService.search(keyword, currentPage, pageSize);
//
//        //响应浏览器
//        ResponseInfo info = new ResponseInfo();
//        info.setCode(200);
//        info.setData(pb);
//        String json = new ObjectMapper().writeValueAsString(info);
//        response.getWriter().println(json);
//    }
//}