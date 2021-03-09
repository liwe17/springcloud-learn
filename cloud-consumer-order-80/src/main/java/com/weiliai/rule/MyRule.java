package com.weiliai.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Doug Li
 * @Date 2021/3/9
 * @Describe: 自定义调用策略
 *  此类不能放在@ComponentScan注解可以扫描的路径下
 */
@Configuration
public class MyRule{

    @Bean
    public IRule randomRule(){
        return new RandomRule();
    }

}
