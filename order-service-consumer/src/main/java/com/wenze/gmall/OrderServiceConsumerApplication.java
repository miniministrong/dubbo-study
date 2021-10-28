package com.wenze.gmall;

import com.wenze.gmall.service.OrderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class OrderServiceConsumerApplication {
        public static void main(String[] args) throws IOException {
                ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("consumer.xml");
                OrderService orderService = applicationContext.getBean(OrderService.class);
                orderService.initOrder("1");
                System.out.println("调用完成");
                System.in.read();
        }
}