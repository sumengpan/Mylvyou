package com.smp.service;

import com.smp.dao.CategoryDao;
import com.smp.dao.RouteDao;
import com.smp.dao.RouteImgDao;
import com.smp.dao.SellerDao;
import com.smp.domain.*;
import com.smp.util.MySessionUtils2;

import java.util.List;

public class RouteService {
    public PageBean search(String keyword, int currentPage, int pageSize) {
        //创建分页数据对象
        PageBean pb = new PageBean();
        //设置每当前页号
        pb.setCurrentPage(currentPage);//**1
        //设置每页记录数
        pb.setPageSize(pageSize);//**2
        //设置总记录数
        RouteDao routeDao = MySessionUtils2.getMapper(RouteDao.class);
        //name
        int totalCount = routeDao.findCountByName("%" + keyword + "%");
        //设置总记录数
        pb.setTotalCount(totalCount);//**3


        //设置总页数，每页最多20条
        //整数相除只保留整数，记得加一
        int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
        //得到总页数
        pb.setTotalPage(totalPage);//**4
        //设置list集合
        int start = (currentPage - 1) * pageSize;
        List<Route> list = routeDao.findPageByName("%" + keyword + "%", start, pageSize);
        //得到集合
        pb.setList(list);
        return pb;
    }

    public PageBean findPageByCid(int cid,int currentPage,int pageSize){
        //创建分页数据对象
        PageBean pb = new PageBean();
        //设置每当前页号
        pb.setCurrentPage(currentPage);//**1
        //设置每页记录数
        pb.setPageSize(pageSize);//**2
        //设置总记录数
        RouteDao routeDao = MySessionUtils2.getMapper(RouteDao.class);
        //cid
        int totalCount = routeDao.findCountByCid(cid);
        //设置总记录数
        pb.setTotalCount(totalCount);//**3

        int totalPage = totalCount % pageSize == 0 ?
                totalCount / pageSize : totalCount / pageSize + 1;
        //得到总页数
        pb.setTotalPage(totalPage);//**4
        //设置list集合
        int start = (currentPage - 1) * pageSize;
        List<Route> list = routeDao.findPageByCid(cid,start,pageSize);
        //得到集合
        pb.setList(list);
        return pb;
    }
    public Route findRouteById1(int rid) {

        //路线数据
        RouteDao routeDao = MySessionUtils2.getMapper(RouteDao.class);
        Route route = routeDao.findOneByRid(rid);

        //分类数据
        CategoryDao categoryDao=MySessionUtils2.getMapper(CategoryDao.class);
        Category category=categoryDao.findOneByCid(route.getCid());
        //设置给route对象
        route.setCategory(category);

        //商家数据
        SellerDao sellerDao=MySessionUtils2.getMapper(SellerDao.class);
        Seller seller=sellerDao.findOneBySid(route.getSid());
        //设置给route对象
        route.setSeller(seller);

        //图片数据
        RouteImgDao routeImgDao=MySessionUtils2.getMapper(RouteImgDao.class);
        List<RouteImg> list=routeImgDao.findAllImgByRid(route.getRid());
        //设置给route对象
        route.setImgList(list);


        return route;
    }
    public Route findRouteById2(int rid){

        RouteDao routeDao = MySessionUtils2.getMapper(RouteDao.class);
        Route route = routeDao.findOneByRid(rid);

        return route;
    }
}





















