package com.wenze.gmall.service;

import com.wenze.gmall.bean.UserAddress;

import java.util.List;

public interface OrderService {
    /**
     * 根据用户id初始化订单
     * @param userId 用户id
     */
    List<UserAddress> initOrder(String userId);
}
