package com.weiliai.springcloud.service.impl;

import com.weiliai.springcloud.dao.PaymentDao;
import com.weiliai.springcloud.entities.Payment;
import com.weiliai.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: Doug Li
 * @Date 2021/3/7
 * @Describe: 业务实现层
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
