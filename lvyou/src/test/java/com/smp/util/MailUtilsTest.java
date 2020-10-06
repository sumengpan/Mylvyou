package com.smp.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class MailUtilsTest {

    @Test
    public void sendMail() {
        //参1 收件人
        //参2 内容
        //参3 标题
        MailUtils.sendMail("2263574372@qq.com","<a href='http://localhost:8080/lvyou_war_exploded/activeServlet?activeCode=f43812f68c794732943ffe678e9a4685'>点击激活途牛旅游账户</a>","激活账户");
    }
}