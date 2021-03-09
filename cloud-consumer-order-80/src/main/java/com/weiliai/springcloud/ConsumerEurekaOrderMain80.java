package com.weiliai.springcloud;

import com.weiliai.rule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: Doug Li
 * @Date 2021/3/7
 * @Describe: 订单模块启动类
 */
@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name="cloud-payment-service",configuration = MyRule.class) //配置自定义负载均衡策略
public class ConsumerEurekaOrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerEurekaOrderMain80.class,args);
    }

    /**
     * 此处可以新建配置类加入,也可以在主类直接写
     */
    @Bean
    //@LoadBalanced //集群需要配置调用策略
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
