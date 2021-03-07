package com.weiliai.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: Doug Li
 * @Date 2021/3/7
 * @Describe: 控制层
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    public static final String INVOKE_URL = "http://cloud-provider-payment/payment/";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consul")
    public String paymentInfo() {
        String result = restTemplate.getForObject(INVOKE_URL + "/consul", String.class);
        return result;
    }
}
