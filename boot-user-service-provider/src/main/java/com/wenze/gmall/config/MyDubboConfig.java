package com.wenze.gmall.config;

import com.alibaba.dubbo.config.*;
import com.wenze.gmall.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MyDubboConfig {

  @Bean
  public ApplicationConfig applicationConfig(){
    ApplicationConfig applicationConfig = new ApplicationConfig();
    applicationConfig.setName("boot-user-service-provider");
    return applicationConfig;
  }

  @Bean
  public RegistryConfig registryConfig(){
    RegistryConfig registryConfig = new RegistryConfig();
    registryConfig.setProtocol("zookeeper");
    registryConfig.setAddress("192.168.229.129:2181");
    return registryConfig;
  }

  @Bean
  public ProtocolConfig protocolConfig(){
    ProtocolConfig protocolConfig = new ProtocolConfig();
    protocolConfig.setName("dubbo");
    protocolConfig.setPort(20881);
    return protocolConfig;
  }

  @Bean
  public ServiceConfig<UserService> userServiceServiceConfig(UserService userService) {
    ServiceConfig<UserService> userServiceServiceConfig = new ServiceConfig<>();
    userServiceServiceConfig.setInterface(UserService.class);
    userServiceServiceConfig.setRef(userService);
    userServiceServiceConfig.setVersion("1.0.0");
    // 配置每一个method的信息
    MethodConfig methodConfig = new MethodConfig();
    methodConfig.setName("getUserAddressList");
    methodConfig.setTimeout(1000);
    // 将method的设置保存到service配置中
    List<MethodConfig> methodConfigList = new ArrayList<>();
    methodConfigList.add(methodConfig);
    userServiceServiceConfig.setMethods(methodConfigList);
    return userServiceServiceConfig;
  }

  @Bean
  public MonitorConfig monitorConfig() {
    MonitorConfig monitorConfig = new MonitorConfig();
    monitorConfig.setProtocol("registry");
    return monitorConfig;
  }
}
