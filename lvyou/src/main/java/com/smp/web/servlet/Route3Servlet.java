package com.smp.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smp.domain.PageBean;
import com.smp.domain.ResponseInfo;
import com.smp.service.RouteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/route/*")
public class Route3Servlet extends BaseServlet {
    //  /route/search
    public void search(HttpServletRequest request, HttpServletResponse response)
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

        String json = toJson(200,pb);
        response.getWriter().println(json);
    }
    //  /route/findByCid
    public  void findByCid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1 接收请求，获取参数
        String  cidStr = request.getParameter("cid");
        String  currentPageStr = request.getParameter("currentPage");
        String  pageSizeStr = request.getParameter("pageSize");

        int cid = 0; //"1"  1 "你好" 异常
        try {
            cid = Integer.parseInt(cidStr);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        int currentPage = 1; //"1"  1 "你好" 异常
        try {
            currentPage = Integer.parseInt(currentPageStr);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        int pageSize = 20 ;
        try {
            pageSize = Integer.parseInt(pageSizeStr);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        //2 处理参数
        //业务对象
        RouteService  routeService = new RouteService();
        //根据指定分类 cid 1 查找路线，但是路线记录需要使用分页来显示 currentPage1  pageSize20
        PageBean pb = routeService.findPageByCid(cid,currentPage,pageSize);
        //生成json
        ResponseInfo responseInfo = new ResponseInfo();
        responseInfo.setCode(200);
        responseInfo.setData(pb);
        String json = new ObjectMapper().writeValueAsString(responseInfo);
        //3 响应浏览器

        response.getWriter().println(json);

    }
}










//class design PageBeanHelper BaseServlet
//按关键字搜索keyword，cid
//@WebServlet("/routeServlet")
//public class Route3Servlet extends BaseServlet {
//
//    //复制粘贴RouteServlet-->search方法
//    public void search(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        //接收请求，获取参数
//        String keyword = request.getParameter("keyword");
//        //字符串类型
//        String currentPageStr = request.getParameter("currentPage");
//        //设置多少页
//        String pageSizeStr = request.getParameter("pageSize");
//        //当前页号第一页
//        int currentPage = 1;
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
//        String json = toJson(200,pb);
//        response.getWriter().println(json);
//    }
//
//    //复制粘贴Route2Servlet-->findByCid方法
//    public void findByCid(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        //接收请求，获取参数
//        String cidStr = request.getParameter("cid");
//        //字符串类型
//        String currentPageStr = request.getParameter("currentPage");
//        //设置多少页
//        String pageSizeStr = request.getParameter("pageSize");
//
//        int cid = 0;
//        try {
//            cid=Integer.parseInt(cidStr);
//        }catch (NumberFormatException e){
//            e.printStackTrace();
//        }
//
//        //当前页号第一页
//        int currentPage=1;
//        try {
//            currentPage = Integer.parseInt(currentPageStr);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        //设置每页记录数为20
//        int pageSize = 20;
//        try {
//            pageSize = Integer.parseInt(pageSizeStr);//11
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        //处理参数
//        RouteService routeService = new RouteService();
//        //PageBean pb =  routeService.search("长沙",1,20);
//        //分页数据对象
//        PageBean pb =  routeService.findPageByCid(cid,currentPage,pageSize);
//
//        //响应浏览器,生成json
//        ResponseInfo responseInfo = new ResponseInfo();
//        responseInfo.setCode(200);
//        responseInfo.setData(pb);
//        String json = new ObjectMapper().writeValueAsString(responseInfo);
//        //响应浏览器
//        response.getWriter().println(json);
//    }
//}