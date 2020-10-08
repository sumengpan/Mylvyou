package com.smp.dao;

import com.smp.domain.User;

public interface UserDao {
    //根据用户名查找用户
    //select * from tab_user where username = 'jackhello'
    User findByName(String name);

    //根据
    //select * from tab_user where username='jackhello3'
    User findByUserName(String username);

    //添加用户
    //insert into tab_user values(null,...)
    void save(User user2);

    //修改状态
    //update tab_user set status ='Y' where code = 'bb26f0d05ea745c5986bc18ff7b4cef9';
    int updateStatus(String activeCode);

}
