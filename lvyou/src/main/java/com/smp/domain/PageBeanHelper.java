package com.smp.domain;

//做一个封装
public class PageBeanHelper {
    public static PageBean start(int currentPage, int pageSize) {
        //创建分页数据对象  包含4个整数与一个集合
        PageBean pb = new PageBean();
        //设置当前页号
        pb.setCurrentPage(currentPage);//1*
        //设置每页记录数
        pb.setPageSize(pageSize);//2
        //为了支持链式调用
        return pb;
    }
}
