package com.smp.dao;

import com.smp.domain.Route;

import java.util.List;

public interface RouteDao {
    //根据关键字查找所有的路线
    //select * from tab_route where rname like "%长沙%"
    int findCountByName(String keyword);

    //根据关键字查找所有的路线并进行分组
    //select * from tab_route where rname like '%长沙%' limit 0,20
    List<Route> findPageByName(String keyword,int start ,int pageSize);


    //根据id查找路线
    //select count(*) from tab_route where cid=1;
    int findCountByCid(int cid);

    //根据id查找路线并进行分组
    //select * from tab_route where cid=5 limit 40,20;
    List<Route> findPageByCid(int cid, int start, int pageSize);

    //根据路线id查找所有
    //select * from tab_route r where r.rid=1;
    Route findOneByRid(int rid);
}
