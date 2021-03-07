package com.weiliai.springcloud.controller;

import com.weiliai.springcloud.entities.CommonResult;
import com.weiliai.springcloud.entities.Payment;
import com.weiliai.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Doug Li
 * @Date 2021/3/7
 * @Describe: 支付模块控制层
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("*****插入结果:[{}]",result);
        return new CommonResult(200,"插入数据库成功");
    }

    @GetMapping(value = "/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if(null==payment)
            return new CommonResult(444,"没有对应记录,查询ID: "+id,null);
        return new CommonResult<Payment>(200,"查询成功",payment);
    }


}
