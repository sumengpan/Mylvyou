package com.smp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smp.domain.PageBean;
import com.smp.domain.ResponseInfo;
import com.smp.domain.Route;
import org.junit.Test;


import java.util.List;

public class TestRouteService {
    @Test
    public void test01() {
        //创建业务对象
        RouteService routeService = new RouteService();
        //所有的分类
        //业务方法
        //不可返回结果使用List<Route>
        //分页中需要有，总记录数，每页记录数，总页数，当前页
        PageBean pageBean = routeService.search("长沙", 1, 20);
        //显示
        System.out.println(pageBean);
    }
        @Test
        public void test02 () throws JsonProcessingException {
            //业务对象
            RouteService routeService = new RouteService();
            //根据指定分类 cid 1 查找路线，但是路线记录需要使用分页来显示 currentPage1  pageSize20
            PageBean pb = routeService.findPageByCid(1, 1, 20);
            //生成json
            ResponseInfo responseInfo = new ResponseInfo();
            responseInfo.setCode(200);
            responseInfo.setData(pb);
            String json = new ObjectMapper().writeValueAsString(responseInfo);
            System.out.println(json);
        }

        @Test
        public void test03 () throws JsonProcessingException {
            //业务，根据 路线的rid查找 路线的数据，商家的数据，分类的数据，图片的数据
            RouteService routeService = new RouteService();
            int rid = 1;
            Route route = routeService.findRouteById2(rid);
            System.out.println(route.getCategory());
            System.out.println(route.getSeller());
            System.out.println(route.getImgList());
        }

}




















