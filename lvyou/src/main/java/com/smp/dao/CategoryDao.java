package com.smp.dao;

import com.smp.domain.Category;

import java.util.List;

public interface CategoryDao {
    //查找所有的分类
    //select * from tab_category order by cid asc;
    List<Category> findAll();

    //根据id查找分类
    //select * from tab_category c where c.cid=1;
    Category findOneByCid(int cid);

}
