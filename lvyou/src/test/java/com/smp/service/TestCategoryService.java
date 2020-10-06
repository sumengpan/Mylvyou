package com.smp.service;

import com.smp.domain.Category;
import org.junit.Test;

import java.util.List;

public class TestCategoryService {
    @Test
    public void test01(){
        //创建业务对象
        CategoryService categoryService=new CategoryService();
        //所有的分类
        List<Category> categoryList=categoryService.findAll();
        //显示
        System.out.println(categoryList);

    }
}





















