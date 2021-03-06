package com.weiliai.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: Doug Li
 * @Date 2021/3/7
 * @Describe: 启动类
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerConsulOrderMain82 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerConsulOrderMain82.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
