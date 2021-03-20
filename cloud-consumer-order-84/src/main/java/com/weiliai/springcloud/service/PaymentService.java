package com.weiliai.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: Doug Li
 * @Date 2021/3/14
 * @Describe: 基于openfeign业务接口
 */
@FeignClient(value = "EUREKA-PAYMENT-SERVICE",fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    String paymentHystrixOk(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    String paymentHystrixTimeout(@PathVariable("id") Long id);

}
