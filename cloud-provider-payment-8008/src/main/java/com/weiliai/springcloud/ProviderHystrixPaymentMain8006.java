package com.weiliai.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @Author: Doug Li
 * @Date 2021/3/14
 * @Describe: 启动类
 */
@SpringBootApplication
@EnableEurekaClient
//@EnableCircuitBreaker
@EnableHystrix //关闭server端服务降级继承@EnableCircuitBreaker
public class ProviderHystrixPaymentMain8006 {

    public static void main(String[] args) {
        SpringApplication.run(ProviderHystrixPaymentMain8006.class,args);
    }
}
