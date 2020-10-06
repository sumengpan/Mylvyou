package com.smp.service;

import com.smp.dao.RouteDao;
import com.smp.domain.PageBean;
import com.smp.domain.Route;
import com.smp.util.MySessionUtils2;

import java.util.List;

public class RouteService {
    public PageBean search(String keyword,int currentPage,int pageSize){
        //创建分页数据对象
        PageBean pb=new PageBean();
        //设置每当前页号
        pb.setCurrentPage(currentPage);
        //设置每页记录数
        pb.setPageSize(pageSize);
        //设置总记录数
        RouteDao routeDao= MySessionUtils2.getMapper(RouteDao.class);
        //
        int totalCount =routeDao.findCountByName("%"+keyword+"%");
        //
        pb.setTotalCount(totalCount);
        //设置总页数，每页最多20条
        //整数相除只保留整数，记得加一
        int totalPage =totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
        //得到总页数
        pb.setTotalPage(totalPage);
        //设置list集合
        int start =(currentPage-1)*pageSize;
        List<Route> list=routeDao.findPageByName("%"+keyword+"%",start,pageSize);
        //得到集合
        pb.setList(list);
        return pb;
    }
}





















