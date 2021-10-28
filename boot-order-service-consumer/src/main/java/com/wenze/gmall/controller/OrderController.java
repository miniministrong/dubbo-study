package com.wenze.gmall.controller;

import com.wenze.gmall.bean.UserAddress;
import com.wenze.gmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @ResponseBody
    @RequestMapping("/initOrder")
    public List<UserAddress> initOrder (@RequestParam("uid") String userId){
        return orderService.initOrder(userId);
    }
}
