package com.weiliai.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Doug Li
 * @Date 2021/3/14
 * @Describe: 业务层
 */
@Service
public class PaymentService {

    /**
     * 正常访问
     */
    public String paymentHystrixOk(Long id){
        return String.format("线程池:[%s] paymentHystrixOk,id:[%s]",Thread.currentThread().getName(),id);
    }


    /**
     * 1.模拟超时
     * 2.模拟异常
     */
    @HystrixCommand(fallbackMethod = "paymentHystrixTimeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500" )//默认1S
    })
    public String paymentHystrixTimeout(Long id){
        //int age = 10/0;
        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return String.format("线程池:[%s] paymentHystrixTimeout,id:[%s]",Thread.currentThread().getName(),id);
    }

    /**
     * 必须paymentHystrixTimeout参数一致
     */
    public String paymentHystrixTimeoutHandler(Long id){
        return String.format("线程池:[%s],系统繁忙 paymentHystrixTimeoutHandler,id:[%s]",Thread.currentThread().getName(),id);
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(Long id){
        if(id<0){
            throw new RuntimeException("id 不能为负数");
        }
        final String serialNumber = IdUtil.simpleUUID();
        return String.format("线程名:[%s] \t 调用成功,流水号:[%s]",Thread.currentThread().getName(),serialNumber);
    }

    public String paymentCircuitBreakerFallback(Long id){
        return String.format("id:[%s],不能为负数,请稍后重试",id);
    }

}
