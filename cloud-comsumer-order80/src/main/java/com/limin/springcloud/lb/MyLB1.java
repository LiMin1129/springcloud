package com.limin.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author LiMin
 * @date 2021/12/24-22:36
 * @DESCRIPTION
 */
public class MyLB1 implements LoadBalancer{
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        ServiceInstance instance = serviceInstances.get(index);
        return instance;
    }
    public final int getAndIncrement(){
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0: current + 1;
        }while (!this.atomicInteger.compareAndSet(current, next));
        return next;
        }
    }
