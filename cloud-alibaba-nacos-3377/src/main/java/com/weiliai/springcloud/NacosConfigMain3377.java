package com.weiliai.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: Doug Li
 * @Date 2021/3/31
 * @Describe: 启动类
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfigMain3377 {


    public static void main(String[] args) {
        SpringApplication.run(NacosConfigMain3377.class,args);
    }

}
