package com.wenze.gmall.service.impl;

import com.wenze.gmall.bean.UserAddress;
import com.wenze.gmall.service.UserService;
import org.springframework.util.StringUtils;

import java.util.List;

public class UserServiceStub implements UserService {

  private final UserService userService;

  /**
   * 传入的是userService远程的代理对象
   * @param userService
   */
  public UserServiceStub(UserService userService) {
    super();
    this.userService = userService;
  }

  @Override
  public List<UserAddress> getUserAddressList(String userId) {
    System.out.println("OrderServiceConsumer中的UserServiceStub本地存根被调用了！");
    if (!StringUtils.isEmpty(userId)) {
      return userService.getUserAddressList(userId);
    }
    return null;
  }
}
