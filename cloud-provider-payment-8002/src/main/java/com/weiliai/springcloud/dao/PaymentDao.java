package com.weiliai.springcloud.dao;

import com.weiliai.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: Doug Li
 * @Date 2021/3/7
 * @Describe: 数据接入层
 */
@Mapper
public interface PaymentDao {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
