package com.smp.service;


import com.smp.domain.User;
import org.junit.Test;

import java.util.Date;

//测试
public class TestUserService {
    @Test
    public void test01() {
        //将用户输入账号与密码发到后台
        UserService userService = new UserService();
        //1:查找用户数据
        User user = userService.findUserByName("jackhello");
        //2:根据数据， 正确，错误，不存在。
        if (user == null) {
            System.out.println("不存在");
        } else {
            //1:3种情况
            System.out.println("存在");
        }
    }

    @Test
    public void test02() {
        //将用户输入账号与密码发到后台
        UserService userService = new UserService();
        //1:查找用户数据
        User user = new User();
        user.setUsername("jackhello");
        user.setPassword("12345678");
        user.setStatus('Y');
        int code = userService.login(user);
        //2:根据数据， 正确，错误，不存在。
        System.out.println(code);
    }
    @Test
    public void test03() {

        UserService userService = new UserService();

        User user= new User(44,"jackhello44","jackhello34",new Date(),"jack","男","3333","333@qq.com",'N',"ddd");
        int code = userService.register(user);

        System.out.println(code);
    }

    @Test
    public void test04() {
        UserService userService = new UserService();
        //根据 code -> status 改为Y
        int code = userService.active("bb26f0d05ea745c5986bc18ff7b4cef9");
        System.out.println(code);
    }
}
