package com.weiliai.springcloud.lb;


import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: Doug Li
 * @Date 2021/3/9
 * @Describe: 自定义负载均衡策略
 */
@Component
public class MyLb implements LoadBalancer {

    private static final AtomicInteger atoInt = new AtomicInteger(0);

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {

        int current;
        int next;
        do{
            current = atoInt.get();
            next = Math.max((current + 1), 0); //防止溢出
        }while (!atoInt.compareAndSet(current,next));
        final int size = next%serviceInstances.size();
        return serviceInstances.get(size);
    }

    public static void main(String[] args) {
        final AtomicInteger atomicInteger = new AtomicInteger(Integer.MAX_VALUE);
        System.out.println(atomicInteger.incrementAndGet());
        System.out.println(atomicInteger.incrementAndGet());
    }
}
