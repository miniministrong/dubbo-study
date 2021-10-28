package com.wenze.gmall.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wenze.gmall.bean.UserAddress;
import com.wenze.gmall.service.OrderService;
import com.wenze.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * 1.将服务提供者注册到注册中心（暴露服务）
 *  1)导入Dubbo依赖
 *  2)配置服务提供者
 * 2.让服务消费者去注册中心订阅服务提供者的服务地址
 */

@Service
public class OrderServiceImpl implements OrderService {
    // @Autowired
    // @Reference(url = "127.0.0.1:20882") // dubbo直连
    @Reference(loadbalance = "roundrobin")
    private UserService userService;

    @HystrixCommand(fallbackMethod = "hello")
    @Override
    public List<UserAddress> initOrder(String userId) {
        System.out.println("用户id：" + userId);
        // 1.查询用户的收货地址
        List<UserAddress> userAddressList = userService.getUserAddressList(userId);
        System.out.println(userAddressList);
        return userAddressList;
    }

    public List<UserAddress> hello(String userId) {
        return Arrays.asList(new UserAddress(10, "测试地址", "1", "测试", "测试", "Y"));
    }
}
