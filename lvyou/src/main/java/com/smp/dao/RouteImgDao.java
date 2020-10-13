package com.smp.dao;

import com.smp.domain.RouteImg;

import java.util.List;

public interface RouteImgDao {

    //根据路线图片的id查找所有
    //select * from  tab_route_img i where i.rid=1;
    List<RouteImg> findAllImgByRid(int rid);
}
