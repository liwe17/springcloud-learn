package com.weiliai.springcloud.controller;

import com.weiliai.springcloud.entities.CommonResult;
import com.weiliai.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: Doug Li
 * @Date 2021/3/7
 * @Describe: 控制层
 */
@RestController
@RequestMapping("/order")
public class OrderController {

//    private static final String PAYMENT_URL = "http://localhost:8001/payment/"; //单机使用

    //单机或者集群可以使用,集群时,restTemplate需要配置负载均衡,否则无法确认使用具体那台服务
    private static final String PAYMENT_URL = "http://cloud-payment-service/payment/";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL, payment, CommonResult.class);
    }

    @GetMapping("/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + id, CommonResult.class);
    }

}
