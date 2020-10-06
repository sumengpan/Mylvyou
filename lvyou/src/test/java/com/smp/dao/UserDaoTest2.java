package com.smp.dao;


import com.smp.domain.User;
import com.smp.util.MySessionUtils2;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class UserDaoTest2 {

    @Test
    public void findByUserName() {
        UserDao dao =    MySessionUtils2.getMapper(UserDao.class);
        User user = dao.findByUserName("jackhello");
        System.out.println(user);
    }

    @Test
    public void save() {
        UserDao dao =    MySessionUtils2.getMapper(UserDao.class);
        User user= new User(33,"jackhello33","jackhello34",new Date(),"jack","男","3333","333@qq.com",'N',"ddd");
        // User(int uid, String username, String password, Date birthday, String name, String sex, String telephone, String email, char status, String code)
        dao.save(user);
        MySessionUtils2.commitAndClose();
    }

    @Test
    public void update() {
        UserDao dao =    MySessionUtils2.getMapper(UserDao.class);
        int code =  dao.updateStatus("f43812f68c794732943ffe678e9a4685");
        System.out.println(code);
        MySessionUtils2.commitAndClose();

        //lvyou/activeServlet?activeCode=f43812f68c794732943ffe678e9a4685
    }
}