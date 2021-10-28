package com.wenze.gmall.service.impl;

import com.wenze.gmall.bean.UserAddress;
import com.wenze.gmall.service.OrderService;
import com.wenze.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 1.将服务提供者注册到注册中心（暴露服务）
 *  1)导入Dubbo依赖
 *  2)配置服务提供者
 * 2.让服务消费者去注册中心订阅服务提供者的服务地址
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private UserService userService;
    @Override
    public List<UserAddress> initOrder(String userId) {
        System.out.println("用户id：" + userId);
        // 1.查询用户的收货地址
        List<UserAddress> userAddressList = userService.getUserAddressList(userId);
        System.out.println(userAddressList);

        for (UserAddress userAddress : userAddressList) {
            System.out.println(userAddress.getUserAddress());
        }
        return userAddressList;
    }
}
