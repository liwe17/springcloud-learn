package com.weiliai.springcloud.controller;

import com.weiliai.springcloud.entities.CommonResult;
import com.weiliai.springcloud.entities.Payment;
import com.weiliai.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Doug Li
 * @Date 2021/3/7
 * @Describe: 支付模块控制层
 */
@RestController
@Slf4j
@RequestMapping("/payment")
@SuppressWarnings("all")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****插入结果:[{}]", result);
        return new CommonResult(200, "插入数据库成功,serverPort: " + serverPort, result);
    }

    @GetMapping(value = "/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (null == payment)
            return new CommonResult(444, "没有对应记录,查询ID: " + id, null);
        return new CommonResult<>(200, "查询成功,serverPort: " + serverPort, payment);
    }

    @GetMapping("/discovery")
    public DiscoveryClient getDiscoveryClientInfo() {
        //获取注册的服务
        discoveryClient.getServices().forEach(element -> {
            log.info("*****element: [{}]", element);
        });
        //获取对应服务的提供者信息
        discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE").forEach(instance -> {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        });

        return discoveryClient;
    }

    @GetMapping(value = "/lb")
    public String getPaymentLB() {
        return serverPort;
    }

    @GetMapping(value = "/print/{id}")
    public String printById(@PathVariable("id") Long id) {
        log.info("*****id:[{}]",id);
        return serverPort;
    }


    @GetMapping(value = "/feign/timeout")
    public String paymentFeignTimeout(){
        try {
            //业务逻辑处理正确,但是需要耗费3秒钟
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
