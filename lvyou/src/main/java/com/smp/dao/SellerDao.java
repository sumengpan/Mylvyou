package com.smp.dao;

import com.smp.domain.Seller;

public interface SellerDao {

    //根据商家id查找所有
    //select * from tab_seller s where s.sid = 1;
    Seller findOneBySid(int sid);

}
