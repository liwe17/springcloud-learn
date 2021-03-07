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
//@EnableEurekaClient
@EnableDiscoveryClient //可以替换@EnableEurekaClient 只使用eureka注册中心,适用于其他服务中心
public class ProviderEurekaPaymentMain8001 {

    public static void main(String[] args) {
        SpringApplication.run(ProviderEurekaPaymentMain8001.class,args);
    }

}
