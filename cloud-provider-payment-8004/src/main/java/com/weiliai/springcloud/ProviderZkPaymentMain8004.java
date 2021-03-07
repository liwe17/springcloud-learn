package com.weiliai.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: Doug Li
 * @Date 2021/3/7
 * @Describe: 启动类
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderZkPaymentMain8004 {

    public static void main(String[] args) {
        SpringApplication.run(ProviderZkPaymentMain8004.class,args);
    }

}
