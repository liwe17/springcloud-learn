package com.weiliai.springcloud.controller;

import com.weiliai.springcloud.entities.CommonResult;
import com.weiliai.springcloud.entities.Payment;
import com.weiliai.springcloud.service.PaymentService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: Doug Li
 * @Date 2021/3/11
 * @Describe: 控制层
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private ApplicationContext applicationContext;

    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentService.getPaymentById(id);
    }

    @GetMapping(value = "/feign/timeout")
    public String paymentFeignTimeout() {
        System.err.println(applicationContext.getBean(PaymentService.class));
        // OpenFeign客户端一般默认等待1秒钟
        return paymentService.paymentFeignTimeout();
    }

}
