package com.smp.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smp.domain.Category;
import com.smp.domain.ResponseInfo;
import com.smp.service.CategoryService;
import com.smp.util.JedisUtil;
import redis.clients.jedis.Jedis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/categoryServlet")
public class CategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //访问redis 较快,但是第一次是没有数据的
        //访问service，获取json，将json保存到redis
        Jedis jedis = JedisUtil.getJedis();
        String json = jedis.get("category_list");

        if (json != null) {
            System.out.println("redis cache");
            response.getWriter().println(json);

        } else {
            System.out.println("mysql data");
            //创建业务对象
            CategoryService categoryService = new CategoryService();
            //所有的分类
            List<Category> categoryList=categoryService.findAll();
            //显示
            ResponseInfo info = new ResponseInfo();
            info.setCode(200);
            info.setData(categoryList);
            json = new ObjectMapper().writeValueAsString(info);
            //将数据保存到redis
            jedis.set("category_list",json);
            response.getWriter().println(json);
        }
        //关闭连接
        JedisUtil.close(jedis);
    }
}
