package com.weiliai.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: Doug Li
 * @Date 2021/3/14
 * @Describe: 启动类
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class ConsumerHystrixOrderMain {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerHystrixOrderMain.class,args);
    }

}
