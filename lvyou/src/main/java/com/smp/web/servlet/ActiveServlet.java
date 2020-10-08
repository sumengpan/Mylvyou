package com.smp.web.servlet;

import com.smp.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//激活账户
@WebServlet("/activeServlet")
public class ActiveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数  activeCode  //lvyou/activeServlet?activeCode=bb26f0d05ea745c5986bc18ff7b4cef9
        String activeCode = request.getParameter("activeCode");
        //处理参数
        UserService userService = new UserService();
        int code = userService.active(activeCode);
        System.out.println(activeCode);
        //响应给浏览器
        String msg = "";
        if(code==1){
            msg="激活成功可以使用";
        }else{
            msg="激活失败";
        }
        request.setAttribute("msg",msg);
        request.getRequestDispatcher("message.jsp").forward(request,response);
    }
}
