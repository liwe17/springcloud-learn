package com.weiliai.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: Doug Li
 * @Date 2021/3/7
 * @Describe: 支付模块启动类
 */
@SpringBootApplication
@EnableDiscoveryClient //可以替换@EnableEurekaClient 只使用eureka注册中心,适用于其他服务中心
//@EnableEurekaClient
// 引入对应依赖包后,此注解可以不写,如果引入依赖包不想启动注册,有两种方式
// 1. 删除eureka相关配置文件
// 2. 修改下面两个配置,只选第一个或者两个都关即可,但如果只选第二个,eureka服务端不启用,会报错,但不影响使用
//    eureka.client.enabled=false,关闭eureka功能
//    eureka.client.register-with-eureka=false
public class ProviderEurekaPaymentMain8001 {

    public static void main(String[] args) {
        SpringApplication.run(ProviderEurekaPaymentMain8001.class,args);
    }

}
