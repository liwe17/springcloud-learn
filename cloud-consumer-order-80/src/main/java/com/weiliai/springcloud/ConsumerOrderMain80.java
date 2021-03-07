package com.weiliai.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: Doug Li
 * @Date 2021/3/7
 * @Describe: 订单模块启动类
 */
@SpringBootApplication
public class ConsumerOrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderMain80.class,args);
    }

    /**
     * 此处可以新建配置类加入,也可以在主类直接写
     */
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
