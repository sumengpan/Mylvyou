package com.smp.service;

import com.smp.dao.RouteDao;
import com.smp.domain.PageBean;
import com.smp.domain.PageBeanHelper;
import com.smp.domain.Route;
import com.smp.util.MySessionUtils2;

import java.util.List;

public class RouteService2 {
    //搜索功能
    public PageBean search(String keyword, int currentPage, int pageSize) {

        RouteDao routeDao = MySessionUtils2.getMapper(RouteDao.class);
        //'%长沙%'
        int totalCount = routeDao.findCountByName("%" + keyword + "%");
        //设置PageBean中的list集合
        int start = (currentPage - 1) * pageSize;
        List<Route> list = routeDao.findPageByName("%" + keyword + "%", start, pageSize);

        //对currentPage与pageSize赋值
        //完成对totalCount与totalPage的赋值
        //完成了对list的赋值
        PageBean pb = PageBeanHelper.start(currentPage, pageSize).count(totalCount).list(list);

        return pb;
    }

    public PageBean findPageByCid(int cid, int currentPage, int pageSize) {
        RouteDao routeDao = MySessionUtils2.getMapper(RouteDao.class);

        int totalCount = routeDao.findCountByCid(cid);

        int start = (currentPage - 1) * pageSize;

        List<Route> list = routeDao.findPageByCid(cid, start, pageSize);

        return PageBeanHelper.start(currentPage, pageSize).count(totalCount).list(list);
    }
}
