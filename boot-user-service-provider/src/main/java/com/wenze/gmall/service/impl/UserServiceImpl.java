package com.wenze.gmall.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wenze.gmall.bean.UserAddress;
import com.wenze.gmall.service.UserService;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Service // 暴露服务
@Component
public class UserServiceImpl implements UserService {
    @HystrixCommand
    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        System.out.println("UserServiceImpl...2...");
        UserAddress address1 = new UserAddress(1, "北京市昌平区宏福科技园", "1", "李老师", "15698745648", "Y");
        UserAddress address2 = new UserAddress(2, "深圳市宝安区西部硅谷大厦", "1", "张老师", "13896548562", "N");
        if (Math.random() > 0.5) {
            throw new RuntimeException();
        }
        return Arrays.asList(address1, address2);
    }
}
