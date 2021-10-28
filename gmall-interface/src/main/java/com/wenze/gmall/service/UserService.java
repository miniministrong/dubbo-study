package com.wenze.gmall.service;

import com.wenze.gmall.bean.UserAddress;

import java.util.List;

/**
 * 用户服务
 */
public interface UserService {
    /**
     * 根据用户id返回所有的收货地址
     * @param userId 用户id
     * @return 收货地址的集合
     */
    List<UserAddress> getUserAddressList(String userId);
}
