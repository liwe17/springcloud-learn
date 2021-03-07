package com.weiliai.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: Doug Li
 * @Date 2021/3/7
 * @Describe: 订单模块启动类
 */
@SpringBootApplication
@EnableEurekaClient
public class ConsumerOrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderMain80.class,args);
    }

    /**
     * 此处可以新建配置类加入,也可以在主类直接写
     */
    @Bean
    @LoadBalanced //集群需要配置调用策略
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
