package com.weiliai.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.weiliai.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: Doug Li
 * @Date 2021/3/14
 * @Describe: 控制层
 */
@Slf4j
@RestController
@RequestMapping("/order")
@DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod") //只针对@HystrixCommand标注的方法
public class OrderController {

    @Resource
    private PaymentService paymentService;

    @Value("service.port")
    private String serverPort;

    @GetMapping(value = "/hystrix/ok/{id}")
    //@HystrixCommand
    // 如果@FeignClient(value = "EUREKA-PAYMENT-SERVICE",fallback = PaymentFallbackService.class)
    // 不配置fallback,则触发全局处理
    // 配置fallback则触发PaymentFallbackService中的处理方法,无论@HystrixCommand是否配置了fallbackMethod
    public String paymentHystrixOk(@PathVariable("id") Long id) {
        final String result = paymentService.paymentHystrixOk(id);
        log.info("paymentHystrixOk,result:[{}]",result);
        return result;
    }

    @GetMapping(value = "/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentHystrixTimeoutFallbackMethod",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })
    public String paymentHystrixTimeout(@PathVariable("id") Long id) {
        final String result = paymentService.paymentHystrixTimeout(id);
        log.info("paymentFeignTimeout,result:[{}]",result);
        return result;
    }

    public String paymentHystrixTimeoutFallbackMethod(Long id){
        return String.format("消费者[%s],服务提供方系统繁忙,请稍后重试!",serverPort);
    }

    public String paymentGlobalFallbackMethod(){
        return String.format("全局降级方法,消费者[%s],服务提供方系统繁忙,请稍后重试!",serverPort);
    }
}
