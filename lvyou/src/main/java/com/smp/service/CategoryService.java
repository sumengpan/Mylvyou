package com.smp.service;

import com.smp.dao.CategoryDao;
import com.smp.domain.Category;
import com.smp.util.MySessionUtils2;

import java.util.List;

public class CategoryService {
     public List<Category> findAll(){
          //调用
          CategoryDao dao= MySessionUtils2.getMapper(CategoryDao.class);
          //查询所有的分类数据
          List<Category> list=dao.findAll();
          //赋返回值
          return list;
     }
}
