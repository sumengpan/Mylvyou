package com.smp.service;

import com.smp.domain.PageBean;
import org.junit.Test;

public class RouteService2Test {

    @Test
    public void search() {
        RouteService2 rs2 = new RouteService2();
        PageBean pb = rs2.search("长沙", 1, 20);
        System.out.println(pb);
    }

    @Test
    public void findPageByCid() {
        RouteService2 rs2 = new RouteService2();
        PageBean pb = rs2.findPageByCid(1,1,20);
        System.out.println(pb);
    }
}