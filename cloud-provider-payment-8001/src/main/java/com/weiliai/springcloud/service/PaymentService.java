package com.weiliai.springcloud.service;

import com.weiliai.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: Doug Li
 * @Date 2021/3/7
 * @Describe: 支付业务接口
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
