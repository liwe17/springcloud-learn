package com.weiliai.springcloud;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * @Author: Doug Li
 * @Date 2021/3/11
 * @Describe: 启动类基于openfeign
 */
@SpringBootApplication
@EnableFeignClients
public class ConsumerFeignOrderMain83 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignOrderMain83.class,args);
    }

    //用于控制feign日志的打印内容并且只有在DEBUG级别才会打印,还需要配置打印目录
    @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
