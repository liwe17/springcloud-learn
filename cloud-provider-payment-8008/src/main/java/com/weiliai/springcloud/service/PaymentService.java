package com.weiliai.springcloud.service;

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

}
