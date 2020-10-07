package com.smp.service;

import com.smp.domain.Category;
import org.junit.Test;

import java.util.List;

public class TestCategoryService {
    @Test
    public void test01(){
        //创建业务对象
        CategoryService categoryService=new CategoryService();
        //显示所有的分类
        List<Category> categoryList=categoryService.findAll();
        //打印出来
        System.out.println(categoryList);

    }
}





















