package com.smp.dao;

import com.smp.domain.Category;

import java.util.List;

public interface CategoryDao {
    //select * from tab_category order by cid asc;
    List<Category> findAll();

}
