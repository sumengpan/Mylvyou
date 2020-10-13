package com.smp.web.servlet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smp.domain.ResponseInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet("/baseServlet")
public class BaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //可以根据不同的访问路径
        String uri = req.getRequestURI();//访问路径
        //search  or  findByCid
        System.out.println(uri);
        int start = uri.lastIndexOf('/') + 1;
        String methodName = uri.substring(start);
        //根据名字调用当前类的其他方法
        //根据一个类的方法名获取当前的方法对象
        try {
            Method method = this.getClass().getMethod
                    (methodName, HttpServletRequest.class, HttpServletResponse.class);
            //参1 方法名 参2 如果方法名一样，可以根据参数的不同来区别
            //调用invoke执行方法
            if(method!=null){
                method.invoke(this, req, resp);//参1 对象 参2  方法的实参
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //将对象转成json
    public String toJson(int code,Object data) {
        ResponseInfo info = new ResponseInfo();
        info.setCode(200);
        info.setData(data);
        String json = null;
        try {
            json = new ObjectMapper().writeValueAsString(info);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
}
