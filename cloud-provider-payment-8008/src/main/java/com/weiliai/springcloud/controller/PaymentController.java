package com.weiliai.springcloud.controller;

import com.weiliai.springcloud.service.PaymentService;
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
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/hystrix/ok/{id}")
    public String paymentHystrixOk(@PathVariable("id") Long id){
        return paymentService.paymentHystrixOk(id);
    }

    @GetMapping("/hystrix/timeout/{id}")
    public String paymentHystrixTimeout(@PathVariable("id") Long id){
        return paymentService.paymentHystrixTimeout(id);
    }

}
