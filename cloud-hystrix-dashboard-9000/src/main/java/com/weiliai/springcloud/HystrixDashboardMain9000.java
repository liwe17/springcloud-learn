package com.weiliai.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Author: Doug Li
 * @Date 2021/3/20
 * @Describe: 启动类
 */
@SpringBootApplication
@EnableHystrixDashboard //访问路径 http://localhost:9000/hystrix
public class HystrixDashboardMain9000 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMain9000.class,args);
    }
}
