package com.weiliai.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author: Doug Li
 * @Date 2021/3/20
 * @Describe: 服务降级代码实现
 *  OrderController无需在额外冗余代码,例如:
 *   @GetMapping(value = "/hystrix/timeout/{id}")
 *     @HystrixCommand(fallbackMethod = "paymentHystrixTimeoutFallbackMethod",commandProperties = {
 *             @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
 *   })
 *   现在只需要
 *   @GetMapping(value = "/hystrix/timeout/{id}")
 */
@Component
public class PaymentFallbackService implements PaymentService {


    @Override
    public String paymentHystrixOk(Long id) {
        return String.format("className:[%s],fallbackMethod:[%s]","PaymentFallbackService","paymentHystrixOk");
    }

    @Override
    public String paymentHystrixTimeout(Long id) {
        return String.format("className:[%s],fallbackMethod:[%s]","PaymentFallbackService","paymentHystrixTimeout");
    }
}
