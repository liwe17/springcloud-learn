package com.weiliai.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: Doug Li
 * @Date 2021/3/7
 * @Describe: 支付模块启动类
 */
@SpringBootApplication
@EnableEurekaClient
public class ProviderPaymentMain8002 {

    public static void main(String[] args) {
        SpringApplication.run(ProviderPaymentMain8002.class,args);
    }

}
