package com.smp.service;

import com.smp.domain.PageBean;
import org.junit.Test;

import java.util.List;

public class TestRouteService {
    @Test
    public void test01(){
        //创建业务对象
        RouteService routeService=new RouteService();
        //所有的分类
        //业务方法
        //不可返回结果使用List<Route>
        //分页中需要有，总记录数，每页记录数，总页数，当前页
        PageBean pageBean = routeService.search("宁夏",1,20);
        //显示
        System.out.println(pageBean);

    }
}





















