package com.wenze.gmall.service.impl;

import com.wenze.gmall.bean.UserAddress;
import com.wenze.gmall.service.UserService;

import java.util.Arrays;
import java.util.List;

public class UserServiceImpl2 implements UserService {
    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        System.out.println("userServiceImpl...new...");
        UserAddress address1 = new UserAddress(1, "北京市昌平区宏福科技园", "1", "李老师", "15698745648", "Y");
        UserAddress address2 = new UserAddress(2, "深圳市宝安区西部硅谷大厦", "1", "张老师", "13896548562", "N");
        return Arrays.asList(address1, address2);
    }
}
