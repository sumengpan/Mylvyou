package com.smp.dao;

import com.smp.domain.Route;

import java.util.List;

public interface RouteDao {
    //select * from tab_route where rname like "%长沙%"
    int findCountByName(String keyword);
    //select * from tab_route where rname like '%长沙%' limit 0,20
    List<Route> findPageByName(String keyword,int start ,int pageSize);

}
